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

    public boolean RandomRemove(StudentArrayDeque<Integer> stu, ArrayDequeSolution<Integer> sol, double random) {
        Integer a;
        Integer b;
        if (random <= 0.5){
            a = stu.removeFirst();
            b = sol.removeFirst();
            ErrorMsg += "removeFirst()\n";
        } else{
            a = stu.removeLast();
            b = sol.removeLast();
            ErrorMsg += "removeLast()\n";
        }

        return a == b;

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
            
            boolean r1 = RandomRemove(stu1,sol1,random3);
            assertTrue(ErrorMsg,r1);


        }

    }

}

