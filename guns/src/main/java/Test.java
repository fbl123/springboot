/**
 * Created by Administrator on 2019/3/27.
 */
public class Test {


    public static void main(String[] args) {

        Data[][] datas = new Data[3][3];


       for (int i=0;i<datas.length;i++){

           for (int j = 0; j < datas.length; j++) {
               datas[i][j]=new Data(i);
           }
       }

        for (int i = 0; i < datas.length; i++) {

            for (int j = 0; j < datas.length; j++) {
                System.out.println(datas[i][j]);
            }


        }


    }

    public static void prilrnt(Data data) {


    }

}
