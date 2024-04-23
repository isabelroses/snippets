int linearSearcg(int keys[], int key, int start, int end) {
	if (start > end) {
		return -1; /* empty array cannot contain the key  */
	}
	if (keys[start] == key) {
		return start; /* key found at the start */
	} else {
		return linearSearcg(keys, key, start + 1, end);
	}
}
