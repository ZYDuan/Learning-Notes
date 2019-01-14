
排序算法

	//不稳定
	public void selectSort(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < nums.length; j++) {
				min = nums[j] < nums[i] ? j : i;
			}
			swap(nums, i, min);
		}
	}
	
	//稳定
	public void charuSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i; j > 0; j--) {
				if(nums[j] < nums[j - 1])
					swap(nums, j, j - 1);
			}
		}
	}
	
	//稳定
	public void maopaoSort(int[] nums) {
		for(int i = nums.length - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				if(nums[j] > nums[j + 1])
					swap(nums, j, j + 1);
			}
		}
	}
	
	//稳定
	public void mergeSort(int[] nums) {
		merge(nums, 0, nums.length - 1);
	}
	
	public void merge(int[] nums, int i, int j) {
		if(i >= j)
			return;
		int mid = i + ((j - i) >> 1);
		merge(nums, i, mid);
		merge(nums, mid + 1, j);
		sortMerge(nums, i, mid, j);
	}
	
	public void sortMerge(int[] nums, int i, int mid, int j) {
		int len = j - i + 1;
		int[] help = new int[len];
		int l = i;
		int r = mid + 1;
		int m = 0;
		while(l <= mid && r <= j) {
			help[m++] = nums[l] > nums[r] ? nums[r++] : nums[l++];
		}
		
		while(l <= mid)
			help[m++] = nums[l++];
		while(r <= j)
			help[m++] = nums[r++];
		
		for(int x = 0; x < len; x++) {
			nums[x + i] = help[x];
		}
	}
	
	//不稳定
	public void quickSort(int[] nums) {
		quick(nums, 0, nums.length - 1);
	}
	
	public void quick(int[] nums, int i, int j) {
		if(i == j)
			return;
		int[] p = partition(nums, i, j);
		quick(nums, i, p[0]);
		quick(nums, p[1], j);
	}
	
	public int[] partition(int[] nums, int i, int j) {
		int less = i;
		int m = i;
		int most = j - 1;
		while(m <= most) {
			if(nums[m] < nums[j]) {
				swap(nums, m++, less++);
			}else if(nums[m] > nums[j]) {
				swap(nums, m, most--);
			}else {
				m++;
			}
		}
		swap(nums, m, j);
		return new int[] {less - 1, most + 1};
	}
	
	//不稳定
	public void heapSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			heapInsert(nums, i);
		}
		int size = nums.length;
		swap(nums, 0, --size);
		while(size > 0) {
			heapHeavify(nums, 0, size);
			swap(nums, 0, --size);
		}
	}
	
	public void heapInsert(int[] nums, int index) {
		while(nums[index] > nums[(index - 1) / 2]) {
			swap(nums, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}
	
	public void heapHeavify(int[] nums, int index, int size) {
		int i = index * 2 + 1;
		while(i < size) {
			int largest = i + 1 < size && nums[i + 1] > nums[i] ? i + 1 : i;
			if(nums[largest] > nums[index]) {
				swap(nums, largest, index);
				index = largest;
				i = index * 2 + 1;
			}else {
				break;
			}
		}
	}
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
