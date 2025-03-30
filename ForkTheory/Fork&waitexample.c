#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>  // to use wait(NULL) including this header file is mandatory

int main() {
    int pid = fork();  // Create a new process
    int i = 0;
    
    if (pid < 0) {
        // Fork failed
        printf("Fork failed\n");
        exit(1);
    } else if (pid == 0) {
        // This is the child process
        for (i = 0; i < 100; i++) {
            printf("Child Process %ld: Number %d\n", (long)getpid(), i);
        }
    } else {
        // This is the parent process
        wait(NULL); // Parent waits for the child to finish(unlil all lines are executed).
        printf("This is the parent process. Child has finished.\n");
    }

    return 0;
}
/*Explanation : 

1. What Happens If You Don’t Include wait(NULL)?

==> The order of execution between parent and child processes is not guaranteed 
 because process scheduling is handled by the OS. So, Sometimes the parent process might
 print first, sometimes the child might. */
