int partition(int []keys, int left, int right, int pivot) {
  int swap; /* used for key swap */
  while (left < right) {
    while (keys[left] < keys[pivot]) {
      left++; /* search for wrongly placed item */
    }

    while (keys[right] > keys[pivot]) {
      right--; /* search for wrongly placed item */
    }

    /* swap items */
    swap = keys[left];
    keys[left] = keys[right];
    keys[right] = swap;
    /* check if pivot was swapped */
    if (left == pivot) {
      pivot = right; /* update pivot position */
    }
    else if (right == pivot) {
      pivot = left; /* update pivot position */
    }

    if (left < pivot) {
      left++; /* force index to move if different from pivot */
    }
    if (right > pivot) {
      right--; /* force index to move if different from pivot */
    }

    return pivot; /* return updated pivot position */
  }
}

void quickSort(int size, int []keys, int start) {
  int pivot; /* index of pivot element */
  if ( size < 2 ) return; /* nothing to do for arrays of size < 2 */
  /* we should use randomised quicksort instead
   * pivot = start+(size/2);  
   * select some pivot element */
  pivot = start + rng.nextInt(size); /* select random pivot */
  pivot = partition(keys, start, start + size - 1, pivot); /* partition input */
  if (pivot-start < size - pivot - 1) { /* check size of parts */
    quickSort(pivot-start, keys, start); /* sort smaller part */
    quickSort(start + size - pivot - 1, keys, pivot + 1); /* sort larger part */
  } else {
    quickSort(start + size - pivot - 1, keys, pivot + 1); /* sort smaller part */
    quickSort(pivot-start, keys, start); /* sort larger part */
  }
}


/*
 * WARNING: this code will crash 
 * since quick sort is allowed to have a abitary pivot 
 * and recursion depth depends on the size of the different parts
 */
void quickSort(int size, int []keys, int start) {
  int pivot; /* index of pivot element */
  if ( size < 2 ) return; /* nothing to do for arrays of size < 2 */
  pivot = start+(size/2); /* select some pivot element */
  pivot = partition(keys, start, start+size-1, pivot); /* partition */
  quickSort(pivot-start, keys, start); /* sort left part */
  quickSort(start+size-pivot-1, keys, pivot+1); /* sort right part */
}
