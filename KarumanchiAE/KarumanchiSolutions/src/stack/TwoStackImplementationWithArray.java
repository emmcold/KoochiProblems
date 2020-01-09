package stack;

/**
 * Implement two stacks using one array
 * @author emira
 *
 */
public class TwoStackImplementationWithArray {
	//push
	void push(int stackId, int element) throws Exception {
		if(topOne == topTwo-1) {
			throw new Exception("Array is full!");
		}
		if (stackId == 1) {
			arr[++topOne] = element;
		}
		else if(stackId == 2) {
			arr[--topTwo] = element;
		}
	}
	//pop
	int pop(int stackId) {
		if(stackId == 1) {
			return --topOne;
		}
		else
			return ++topTwo;
	}
	//top
	int top(int stackId) {
		if(stackId == 1) {
			return topOne;
		}
		else
			return topTwo;
	}
	//isEmpty
	boolean isEmpty(int stackId) {
		if(stackId == 1) {
			if (topOne == -1) {
				return true;
			}
		}
		else if(stackId == 2) {
			if(topTwo == arraySize) {
				return true;
			}
		}
		return false;
	}
	// size
	int arraySize;
	
	//pointer for left
	int topOne = -1;
	// pointer for right
	int topTwo = arraySize;
	
	public TwoStackImplementationWithArray(int size) {
		this.arraySize = size;
	}
	//array
	int[] arr = new int[arraySize];
	
}