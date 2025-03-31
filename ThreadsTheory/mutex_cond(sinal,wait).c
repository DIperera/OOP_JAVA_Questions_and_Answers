#include <pthread.h>
#include <stdio.h>

pthread_mutex_t mutex;  // Declaring the mutex without initialization
pthread_cond_t cond;    // Declaring the condition variable without initialization
int item = 0;           // Shared resource

void* producer(void* arg) {
    pthread_mutex_lock(&mutex);   // Lock the mutex
    item = 1;  // Produce an item
    printf("Produced item: %d\n", item);
    pthread_cond_signal(&cond); // Signal the consumer that item is produced
    pthread_mutex_unlock(&mutex);  // Unlock the mutex
    return NULL;
}

void* consumer(void* arg) {
    pthread_mutex_lock(&mutex);  // Lock the mutex
    while (item == 0) { // If no item has been produced, wait
        pthread_cond_wait(&cond, &mutex);
    }
    printf("Consumed item: %d\n", item);
    item = 0; // Consume the item
    pthread_mutex_unlock(&mutex);  // Unlock the mutex
    return NULL;
}

int main() {
    pthread_t prod, cons;

    // Dynamically initialize the mutex and condition variable
    pthread_mutex_init(&mutex, NULL);  // Initialize the mutex
    pthread_cond_init(&cond, NULL);    // Initialize the condition variable

    // Create producer and consumer threads
    pthread_create(&prod, NULL, producer, NULL);
    pthread_create(&cons, NULL, consumer, NULL);

    // Wait for both threads to finish
    pthread_join(prod, NULL);
    pthread_join(cons, NULL);

    // Destroy the mutex and condition variable to clean up
    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&cond);

    return 0;
}
