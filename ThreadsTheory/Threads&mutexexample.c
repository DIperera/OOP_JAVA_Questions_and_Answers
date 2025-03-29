#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h> // For sleep() on Linux/Mac

int count = 0; // Shared variable to track iterations
pthread_mutex_t lock; // Mutex for synchronization

// Function for first thread
void *printHello(void *arg) {
    while (1) {
        pthread_mutex_lock(&lock); // Lock the mutex before accessing count
        if (count >= 10) { // Stop if count reaches 10
            pthread_mutex_unlock(&lock);
            break;
        }
        count++; // Increase count
        printf("%d: Hello\n", count);
        pthread_mutex_unlock(&lock); // Unlock the mutex
        sleep(3); // Sleep for 3 seconds
    }
    return NULL;
}

// Function for second thread
void *printWorld(void *arg) {
    while (1) {
        pthread_mutex_lock(&lock);
        if (count >= 10) { // Stop if count reaches 10
            pthread_mutex_unlock(&lock);
            break;
        }
        count++; // Increase count
        printf("%d: World\n", count);
        pthread_mutex_unlock(&lock);
        sleep(1); // Sleep for 1 second
    }
    return NULL;
}

int main() {
    pthread_t thread1, thread2;

    pthread_mutex_init(&lock, NULL); // Initialize the mutex

    // Create the first thread
    if (pthread_create(&thread1, NULL, printHello, NULL) != 0) {
        printf("Error: Failed to create thread 1\n");
        return 1;
    }

    // Create the second thread
    if (pthread_create(&thread2, NULL, printWorld, NULL) != 0) {
        printf("Error: Failed to create thread 2\n");
        return 1;
    }

    // Wait for threads to finish
    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    pthread_mutex_destroy(&lock); // Destroy the mutex

    printf("Parent process executed\n");
    return 0;
}
/*
there are two possible output types:

1. Output starts with "Hello"
2. Output starts with "World"

Why are there only 2 possibilities?

==> The first execution depends on which thread gets the CPU first.

==> Always first 2 outputs display at the same time. Because firstly both threads are executed at once. Only after that the sleeping process happens. 

==> After that, "Hello" (3s sleep) and "World" (1s sleep) compete for execution.

==> again 5 and 6 displays at the same time.

==> The mutex ensures that only one update to count happens at a time.

Possible Output Type 1: Starts with "Hello"

	1: Hello | 0 | 0  (1, 2 displays at the same time)
	2: World | 0 | 1  (1, 2 displays at the same time)
	3: World | 1 | 2
	4: World | 1 | 3
	5: Hello | 1 | 0  (5, 6 displays at the same time)
	6: World | 1 | 1  (5, 6 displays at the same time)
	7: World | 1 | 2
	8: World | 1 | 3
	9: Hello | 1 | 0  (9, 10 displays at the same time)
	10: World | 1 | 1 (9, 10 displays at the same time)
	Parent process executed
	
Explanation:

==> "Hello" starts first (since its thread got CPU first).

Possible Output Type 2: Starts with "World"

	1: World
	2: Hello
	3: World
	4: World
	5: World
	6: Hello
	7: World
	8: World
	9: World
	10: Hello
	Parent process executed
	
Explanation:

==> This time, "World" runs first because its thread got CPU first.

*/