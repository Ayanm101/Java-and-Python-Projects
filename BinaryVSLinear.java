class BinaryVSLinear
{
  private static int linearSearch(int key, int [] array)
  {
  	int comparison = 0;
    for(int i=0;i<array.length;i++)
    {
        if(array[i] == key)
        {
        	comparison = i + 1;
        }
    }
    return comparison;
  }

  private static int binarySearch(int key, int [] array)
  {
    int start = 0;
    int mid;
    int end = array.length - 1;
    int comparison = 0;// no comparisons have been made yet
    while(true) {
    	if (start > end)
    	{
    		mid = -1;
    		comparison ++;//first comparison
    		break;
    	}
    	else {
    		mid = (start + end) / 2;
    		if (key < array[mid])
    		{
    			end = mid - 1;//key is now on the left side
    			comparison += 2;
    		}
    		else if (key > array[mid])
    		{
    			start = mid + 1;
    			comparison += 2;
    		}
    		else {
    			break;
    		}
    	}
    }
    return comparison;
  }

  public static void main(String [] args)
  {


    for (int length = 1; length <= 30; length += 1)
    {
      int[] array = new int[length];
      for (int index = 0; index < length; index += 1)
      {
        array[index] = index;
      }

      double linearTotal = 0.0;
      double binaryTotal = 0.0;
      for (int element = 0; element < length; element += 1)
      {
        linearTotal += linearSearch(element, array);
        binaryTotal += binarySearch(element, array);
      }

      double linearAverage = linearTotal / length;
      double binaryAverage = binaryTotal / length;
      System.out.println(length + " " + linearAverage + " " + binaryAverage);
    }
  }
}