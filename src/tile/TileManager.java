package tile;

import game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {

    private GamePanel gp;
    private Tile[] tileArray;
    private int mapTileCoordinate[][];
    private final int SIZE = 10;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tileArray = new Tile[SIZE];
        mapTileCoordinate = new int[gp.getMaxScreenColumn()][gp.getMaxScreenRow()];
        getTileImage();
        loadMapFromTxt("/maps/map01.txt");
    }

    public void getTileImage(){

        try {
            tileArray[0] = new Tile();
            tileArray[0].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png")));

            tileArray[1] = new Tile();
            tileArray[1].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")));

            tileArray[2] = new Tile();
            tileArray[2].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/water00.png")));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMapFromTxt(String path){
        try (InputStream is = getClass().getResourceAsStream(path);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            int column = 0;
            int row = 0;

            while (column < gp.getMaxScreenColumn() && row < gp.getMaxScreenRow()) {
                String line = br.readLine();

                while (column < gp.getMaxScreenColumn()) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[column]);
                    mapTileCoordinate[column][row] = num;
                    column++;
                }

                if (column == gp.getMaxScreenColumn()) {
                    column = 0;
                    row++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        int column = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(column < gp.getMaxScreenColumn() && row < gp.getMaxScreenRow()){

            int tileNum = mapTileCoordinate[column][row];

            g2d.drawImage(tileArray[tileNum].getImage(), x, y, gp.getTileSize(), gp.getTileSize(), null);
            column++;
            x+=gp.getTileSize();

            if(column == gp.getMaxScreenColumn()){
                column = 0;
                x = 0;
                row++;
                y+=gp.getTileSize();
            }
        }
    }
}
