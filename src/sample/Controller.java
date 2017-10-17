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
    @FXML
    public Label SearchR;

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
            return;
        }else if(!valueInput.getText().isEmpty()&&!indexInput.getText().isEmpty()&& indexNum()<= (list.size()-1)&& indexNum()>-1){
            list.add(indexNum(), valueInput.getText());
            resetPane();
            return;
        }
        else{
            backwordtraversalLable.setText("no value in inserted");
            backwordtraversalLable.setTextFill(Color.RED);
            backwordtraversalLable.setVisible(true);
        }

    }
    public void delete(){
        if(indexInput.getText().isEmpty()){
            list.remove(list.size()-1);
            System.out.println("delete ");
            resetPane();
        }
        else if(!indexInput.getText().isEmpty()&& indexNum()<list.size()){
            list.remove(indexNum());
            resetPane();
        }
    }
    int count= list.size();
    public void search(){

       if(!valueInput.getText().isEmpty()&& !indexInput.getText().isEmpty()&&list.get(indexNum()).equals(valueInput.getText())){
           SearchR.setText("Search Result: Exist");
           SearchR.setVisible(true);
           System.out.println("here ");
           return;
       }
        if(valueInput.getText().isEmpty()&& !indexInput.getText().isEmpty()&&indexNum()<list.size()){
            SearchR.setText("Search Result: Exist");
            SearchR.setVisible(true);
            //System.out.println("index ");
            return;

        }
        if(!valueInput.getText().isEmpty()&& indexInput.getText().isEmpty()&&list.contains(valueInput.getText())){
            SearchR.setText("Search Result: Exist");
            SearchR.setVisible(true);
            //System.out.println("value ");
            return;
        }else
            SearchR.setText("Search Result: Does not Exist");
            SearchR.setVisible(true);
        
    }
    public void resetPane(){
        SearchR.setVisible(false);
        panee.getChildren().clear();
        for (int i=0; i<list.size();i++){
            newNodeBox((String) list.get(i), i,list.size()-1);
            System.out.println(i);
            setBackwordtraversalLable();
            count= list.size();
        }
    }
    public void resetPane(int x){
        SearchR.setVisible(false);
        panee.getChildren().clear();

        if (x==1){ //&& count<list.size()
            count++;
            panee.getChildren().clear();
            for (int i=0; i<list.size();i++){
                newNodeBox((String) list.get(i), i,count);
                //System.out.println(i);

            }
            if(count>list.size()-1){
                count=-1;
                newNodeBox((String) list.get(0), 0,0);
            }
            setBackwordtraversalLable();
            return;
        }
         if (x==-1 ){ //&& count>0
            count--;
             panee.getChildren().clear();
            for (int i=0; i<list.size();i++){
                newNodeBox((String) list.get(i), i,count);
                System.out.println("index  "+i+"  count  "+count);

            }
             if(count<1){
                 count=list.size();
             }
             setBackwordtraversalLable();
             return;
        }else
            resetPane();
            System.out.println("dont know");


    }
    public void setBackwordtraversalLable(){
        String s="";
        for(int i=list.size()-1;i>-1;i--){
            s=s+list.get(i)+" ";
        }
        backwordtraversalLable.setText(s);

    }
    public void forwardTraversalButton(){

        resetPane(1);
    }
    public void backwardTraversalButton(){

        resetPane(-1);
    }
    public void newNodeBox(String info, int index, int curr){  //(String info, int index)
        Rectangle hereBox = new Rectangle(index*80+20, 10, 70, 15);
        Rectangle infoBox = new Rectangle(index*80+20, 13, 70, 15);
        Rectangle nextBox = new Rectangle(index*80+20, 26, 70, 15);
        Rectangle previousBox = new Rectangle(index*80+20, 39, 70, 15);

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
        next.setLayoutY(23);
        next.setLayoutX(index*80+21);
        next.setMinSize(70,12);

        Label pri=new Label("previousLink");
        pri.setLayoutY(35);
        pri.setLayoutX(index*80+21);
        pri.setMinSize(70,12);


        Label s=new Label(info);
        s.setLayoutX(index*80+35);
        s.setLayoutY(11);
        s.setMinWidth(12);
        s.setMinHeight(12);
        if(index==curr){
            Label currLa=new Label("current");
            currLa.setLayoutY(70);
            currLa.setLayoutX(index*80+21);
            currLa.setMinSize(70,12);
            panee.getChildren().addAll(currLa);

        }
        if(index==(list.size()-1)){
            Label tail=new Label("tail");
            tail.setLayoutY(60);
            tail.setLayoutX((list.size()-1)*80+21);
            tail.setMinSize(70,12);
            panee.getChildren().addAll(tail);
            //System.out.println("             tail");

        }
        if(index==0){
            Label head=new Label("head");
            head.setLayoutY(50);
            head.setLayoutX(index*80+21);
            head.setMinSize(70,12);
            panee.getChildren().addAll(head);

        }

        //System.out.println("size"+list.size()+"indexNum "+indexNum()+"  Curr"+(curr-1));
        panee.getChildren().addAll(hereBox,infoBox,nextBox,previousBox,s,next,pri);
        //panee.getChildren().r


    }



}
