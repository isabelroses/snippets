int binarySearch(int keys[], int key, int start, int end) {
	int middle;
	if (start > end) {
		return -1; /* empty array, key not found */
	}
	middle = start + ((end-start) / 2);
	if (keys[middle] == key) {
		return middle; /* key found */
	} else if (keys[middle] < key) {
		return binarySearch(keys, key, middle+1, end); /* search right */
	} else {
		return binarySearch(keys, key, start, middle-1); /* search left */
	}
}
