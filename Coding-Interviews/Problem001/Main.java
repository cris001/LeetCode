在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
思路：从右上角或左下角开始找，逐行删除，或者用二分法查找
代码实现：
public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null){
            return false;
        }
        int r = 0;
        int c = array[0].length - 1;
        while(r< array.length && c>=0){
            if (array[r][c] == target){
                return true;
            }else if (array[r][c] > target){
                c--;
            }else{
                r++;
            }
            
        }
        return false;
    }
}