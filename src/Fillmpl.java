import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Fillmpl {
    private static void fill(int [][]canvas, int fillColor, int x, int y){
        if (canvas[x][y]==fillColor)
            return;

        fill(canvas, canvas[x][y], fillColor, x, y);
    }
    private static void fill(int [][]canvas, int sourceColor, int newColor, int x, int y){
        if(x<0 || y<0 || x>=canvas.length || y>=canvas[0].length || canvas[x][y]!=sourceColor
                || canvas[x][y]==newColor)
            return;

        canvas[x][y]=newColor;
        fill(canvas, sourceColor, newColor, x-1, y);
        fill(canvas, sourceColor, newColor, x+1, y);
        fill(canvas, sourceColor, newColor, x, y-1);
        fill(canvas, sourceColor, newColor, x, y+1);
    }
    private static void fillBfs(int [][]canvas, int newColor, int x, int y){
        if (canvas[x][y]==newColor)
            return;
        Queue<Pixel> queue=new LinkedList<>();
        int sourceColor=canvas[x][y];
        Pixel pixel=new Pixel(x, y);
        queue.add(pixel);
        while (!queue.isEmpty()){

            pixel=queue.poll();
            if (pixel.x<0 || pixel.y<0 || pixel.x>=canvas.length || pixel.y>=canvas[0].length || canvas[pixel.x][pixel.y]!=sourceColor)
                continue;

            canvas[pixel.x][pixel.y]=newColor;
            queue.add(new Pixel(pixel.x-1,pixel.y));
            queue.add(new Pixel(pixel.x+1,pixel.y));
            queue.add(new Pixel(pixel.x,pixel.y+1));
            queue.add(new Pixel(pixel.x,pixel.y-1));
        }
    }
    public static void main(String[] args) {
        int canvas[][]=new int[50][50];
        //Arrays.fill(canvas[0],1);

        fillBfs(canvas, 2, 1,1);
        for (int i=0; i<canvas.length; i++) {
            for (int j = 0; j < canvas[0].length; j++)
                System.out.print(canvas[i][j] + " ");
            System.out.println();
        }
    }
}
