/**
 * Created by Administrator on 2019/3/27.
 */
public class Data {

    private int data;
    private Data left;
    private Data right;
    private Data top;
    private Data bottom;

    public Data(int data) {
        this.data = data;
    }

    public Data() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Data getLeft() {
        return left;
    }

    public void setLeft(Data left) {
        this.left = left;
    }

    public Data getRight() {
        return right;
    }

    public void setRight(Data right) {
        this.right = right;
    }

    public Data getTop() {
        return top;
    }

    public void setTop(Data top) {
        this.top = top;
    }

    public Data getBottom() {
        return bottom;
    }

    public void setBottom(Data bottom) {
        this.bottom = bottom;
    }

    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                ", top=" + top +
                ", bottom=" + bottom +
                '}';
    }
}
