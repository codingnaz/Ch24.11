package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.LinkedList;

public class Controller {
    @FXML
    public Label backwordtraversalLable;
    @FXML
    public Button backwardTraversalButton;
    @FXML
    public Button forwardTraversalButton;
    @FXML
    public Button delete;
    @FXML
    public Button insert;
    @FXML
    public Button search;
    @FXML
    public TextField valueInput;
    @FXML
    public TextField indexInput;
    @FXML
    public Pane panee;

    LinkedList list= new LinkedList();
     public int indexNum(){
         int x=-1;
         if(!indexInput.getText().isEmpty()){
             try{
                 x= Integer.parseInt(indexInput.getText());
             }catch (Exception e){
                 backwordtraversalLable.setText("Invalied index");
             }

         }
         return x;
     }


    public void insert(){
        if(!valueInput.getText().isEmpty()&&indexInput.getText().isEmpty()){
            list.add(valueInput.getText());
            resetPane();
        }else if(!valueInput.getText().isEmpty()&&!indexInput.getText().isEmpty()&& indexNum()<= list.size()&& indexNum()<-1){
            list.add(indexNum(), valueInput.getText());
            resetPane();
        }
        else{
            backwardTraversalButton.setText(" no value in inserted");
        }

    }
    public void delete(){
        if(indexInput.getText().isEmpty()){
            list.remove(list.size());
            resetPane();
        }
        else if(!indexInput.getText().isEmpty()&& indexNum()<list.size()){
            list.remove(indexNum());
            resetPane();
        }
    }
    public void search(){
       // if()
    }
    public void resetPane(){
        panee.getChildren().removeAll();
        for (int i=0; i<list.size();i++){
            newNodeBox((String) list.get(i), i);
        }
    }

    public void newNodeBox(String info, int index){  //(String info, int index)
        Rectangle hereBox = new Rectangle(index*80+20, 10, 80, 13);
        Rectangle infoBox = new Rectangle(index*80+20, 13, 80, 13);
        Rectangle nextBox = new Rectangle(index*80+20, 26, 80, 13);
        Rectangle previousBox = new Rectangle(index*80+20, 39, 80, 13);
        hereBox.setHeight(13);
        hereBox.setWidth(12);
        infoBox.setFill(Color.CYAN);
        infoBox.setStroke(Color.BLACK);
        hereBox.setFill(Color.WHITE);
        hereBox.setStroke(Color.BLACK);
        nextBox.setStroke(Color.BLACK);
        nextBox.setFill(Color.WHITE);
        previousBox.setFill(Color.WHITE);
        previousBox.setStroke(Color.BLACK);
        //infoBox.setT\
        //infoBox.set
        Label next=new Label("NextLink");
        next.setLayoutY(21);
        next.setLayoutX(index*80+20);
        next.setMinSize(80,12);

        Label pri=new Label("previousLink");
        pri.setLayoutY(31);
        pri.setLayoutX(index*80+20);
        pri.setMinSize(80,12);


        Label s=new Label(info);
        s.setLayoutX(index*80+35);
        s.setLayoutY(10);
        s.setMinWidth(12);
        s.setMinHeight(12);

        panee.getChildren().addAll(hereBox,infoBox,nextBox,previousBox,s,next,pri);
        //panee.getChildren().r

    }



}
