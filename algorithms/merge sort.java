void mergeSort(int size, int keys[], int tmp[], int start) {
  int min1, min2; /* inedex of first element in each sequence */
  int i; /* postion in "main array" */
  if (size < 2) return; /* nothing to do for arrays of size < 2 */
  mergeSort(size / 2, keys, tmp, start); /* sort first half */
  mergeSort(size - (size / 2), keys, tmp, start + size / 2); /* sort second half */
  /* merge the left and right half into tmp; tmp must exist and be large enough */
  min1 = start; /* set min1 to the smallest element in the left half */
  min2 = start + (size / 2); /* set min2 to smallest element in right half */
  for ( i=0; i<size; i++ ) { /* in each step copy 1 item to tmp */
    if ((min2 >= start+size) /* right half already empty */
        /* or left half not yet empty and left item minimal */
        || ((min1 < start+(size/2)) && (keys[min1] <= keys[min2]))) {
      tmp[i] = keys[min1++]; /* copy from left half and adjust its index */
    } else {
      tmp[i] = keys[min2++]; /* copy from right half and adjust its index */
    }
  }
  /* copy resulting sorted sequence over the original input */
  for ( i=0; i<size; i++ ) {
    keys[start+i] = tmp[i];
  }
}

/* notes
 *
 * Time complexity: Θ(n log n)
 * Space complexity: O(n)
 *
 * The reccursive calls are: T(n) = 2T(n/2) + Θ(n) this resolves to: Θ(n log n)
 * The merging section is: Θ(n)
 * The copying section is: Θ(n)
 *
 * best and worst case are the same
 */
