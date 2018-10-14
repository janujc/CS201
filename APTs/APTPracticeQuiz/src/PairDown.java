public class PairDown {
    public int listSize(int[] list){
        int a = list.length;
        if (a % 2 == 0) {
            return a/2;
        }
        return a/2 + 1;
    }

    public int[] fold(int[] list) {
        int[] newList = new int[listSize(list)];
        int count = 0;
        int evenList = list.length - (list.length % 2);
        for (int i = 0; i < evenList; i+=2){
            newList[count] = list[i] + list[i + 1];
            count++;
        }
        if (list.length % 2 != 0){
            newList[newList.length - 1] = list[list.length - 1];
        }
        return newList;
    }
}
