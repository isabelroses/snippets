void heapSort(int []keys) {
    int i; /* index variable to run over array */
    int currentSize; /* keep track of remaining heap size */
    int swap; /* memory to keep element for swap */
    /* build heap */
    for ( i=keys.length/2; i>=0; i- - ) {
        reheap(keys.length, keys, i); /* repair heap[i..size-1] */
    }
    /* sort */
    for ( currentSize = keys.length; currentSize>1; currentSize- - ) {
        /* swap root with last element */
        swap = keys[0];
        keys[0] = keys[currentSize-1];
        keys[currentSize-1] = swap;
        /* repair heap */
        reheap(currentSize-1, keys, 0);
    }
}

void reheap(int size, int []keys, int root) {
    int i; /* index variable to run over array */
    int swap; /* memory to keep element for swap */
    int key; /* current key that may need new position */
    /* compute path of larger children */
    i=root; /* start at root */

    while ( (2*i+1)<size ) { /* does left child exist? */
        /* 
          go to larger child
          the order of the comparisons here is important as we stop evaulating if the first value is false
          otherwise we would get an index out of bounds exception
        */
        if ( (2*i+2<size) && (keys[2*i+1] < keys[2*i+2]) ) { 
            i = 2*i+2; /* move to right child */
        } else {
            i = 2*i+1; /* move to left child */
        }
    }/* climb path back up and find where swaps are needed */

    while ( (i>root)&&(keys[root]>=keys[i])) {
        /* look for key > root */
        i=(i-1)/2; /* move path up */
    }
    /* perform swaps */
    key = keys[root]; /* remember root */
    while ( i>root) ) {
        swap=keys[i];
        keys[i]=key;
        key=swap;
        i=(i-1)/2;/* move path up */
    }
    keys[root] = key; /* put key in root */
}

