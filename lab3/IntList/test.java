public class test {
    public static int[] insert(int[] arr, int item, int position){
        int[] result = new int[arr.length+1];

        position = Math.min(arr.length, position);

        for(int i=0 ; i<position; i++){
            result[i]=arr[i];
        }
        result[position] = item;

        for(int j=position+1; j<result.length; j++){
            result[j] = arr[j-1];

        }

        return result;
    }

    public static int[] reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while(left<right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }

        return arr;
    }

    public static int[] replicate(int[] arr){
        int total = 0;
        for (int i=0; i<arr.length ; i++){
            total += arr[i];
        }

        int[] res = new int[total];

        int count = 0;
        for(int item: arr){
            for (int j=count; j<item+count;j++){
                res[j] = item;
            }
            count+=item;
        }

        return res;
    }

    public static void main(String[] args){
        int[] a = new int[]{2,3,5,1,5,6};
        int[] b = new int[]{3,2,1};

        int[] res = insert(a,100,2);

        int[] ans = reverse(a);

        int[] key = replicate(b);




    }
}
