import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

  class Test implements I2 {

    // Driver code

    public static void main(String arg[]) {
        System.out.println(I2.name);
        System.out.println(I2.s1);
        System.out.println(((I1)new Test()).name);

    }

}


interface I1{
      String name = "n1";
      String s1 = "S1";
}

interface I2 extends I1{
      String name = "n2";
}



