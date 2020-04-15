import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    private String ErrorMsg ="\n";


    public void RandomAdd(StudentArrayDeque<Integer> stu, ArrayDequeSolution<Integer> sol, Integer num, double random) {
        if (random <= 0.5){
            stu.addFirst(num);
            sol.addFirst(num);
            ErrorMsg += "addFirst("+num+")\n";
        } else{
            stu.addLast(num);
            sol.addLast(num);
            ErrorMsg += "addLast("+num+")\n";
        }

    }

    public Integer[] RandomRemove(StudentArrayDeque<Integer> stu, ArrayDequeSolution<Integer> sol, double random) {
        Integer[] a = new Integer[2];


        if (random <= 0.5){
            a[0] = stu.removeFirst();
            a[1] = sol.removeFirst();
            ErrorMsg += "removeFirst()\n";
        } else{
            a[0] = stu.removeLast();
            a[1] = sol.removeLast();
            ErrorMsg += "removeLast()\n";
        }


        return a;

    }

    @Test
    public void TestAddFirst() {
        StudentArrayDeque<Integer> stu1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol1 = new ArrayDequeSolution<>();


        while (true) {
            double random1 = StdRandom.uniform();
            double random2 = StdRandom.uniform();
            double random3 = StdRandom.uniform();

            Integer num1 = StdRandom.uniform(1000);
            Integer num2 = StdRandom.uniform(1000);

            RandomAdd(stu1,sol1,num1,random1);
            RandomAdd(stu1,sol1,num2,random2);
            
            Integer[] res = RandomRemove(stu1,sol1,random3);
            assertEquals(ErrorMsg,res[0],res[1]);



        }

    }

}

