package beginningClassWork;

public class StringBuilding {

    public static void main(String[] args) {

        StringBuilder bld = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            StringBuilder minibld = new StringBuilder();
            for(int j = 0; j < 10; j++) {
                minibld.append("L");
            }
            bld.append(minibld.toString() + "\n");
        }

        System.out.println(bld.toString());

        // String grid = "";
        // for(int i = 0; i < 10; i++) {
        //     String line = "";
        //     for(int j = 0; j < 10; j++) {
        //         line+="L";
        //     }
        //     grid+=line+"\n";
        // }

        // System.out.println(grid);

    }


}
