package main;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller {
    private List<Double> s = new ArrayList<>();
    private List<String> n = new ArrayList<>();
    @FXML
    private TextField txtN;
    @FXML
    private ImageView btn1;
    @FXML
    private ImageView btn2;
    @FXML
    private ImageView btn3;
    @FXML
    private ImageView btn4;
    @FXML
    private ImageView btn5;
    @FXML
    private ImageView btn6;
    @FXML
    private ImageView btn7;
    @FXML
    private ImageView btn8;
    @FXML
    private ImageView btn9;
    @FXML
    private ImageView btnMi;
    @FXML
    private ImageView btnPl;
    @FXML
    private ImageView btnTi;
    @FXML
    private ImageView btnDi;
    @FXML
    private ImageView btnAC;
    @FXML
    private ImageView btnC;
    @FXML
    private ImageView btnMM;
    @FXML
    private ImageView btnEq;
    @FXML
    private ImageView btnP;
    @FXML
    private ImageView btn0;
    @FXML
    private void onPClick(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + ".");
        }
        else
            txtN.setText(txtN.getText()+".");    }
    @FXML
    private void on1Click() {
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "1");
        }
        else
            txtN.setText(txtN.getText()+"1");    }
    @FXML
    private void on0Click() {
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "0");
        }
        else
            txtN.setText(txtN.getText()+"0");    }
    @FXML
    private void on2Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "2");
        }
        else
            txtN.setText(txtN.getText()+"2");
    }
    @FXML
    private void on3Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "3");
        }
        else
            txtN.setText(txtN.getText()+"3");
    }
    @FXML
    private void on4Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "4");
        }
        else
            txtN.setText(txtN.getText()+"4");
    }
    @FXML
    private void on5Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "5");
        }
        else
            txtN.setText(txtN.getText()+"5");
    }
    @FXML
    private void on6Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "6");
        }
        else
            txtN.setText(txtN.getText()+"6");
    }
    @FXML
    private void on7Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "7");
        }
        else
            txtN.setText(txtN.getText()+"7");
    }
    @FXML
    private void on8Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "8");
        }
        else
            txtN.setText(txtN.getText()+"8");
    }
    @FXML
    private void on9Click(){
        if (txtN.getText().startsWith("0")){
            txtN.setText("");
            txtN.setText(txtN.getText() + "9");
        }
        else
            txtN.setText(txtN.getText()+"9");
    }
    @FXML
    private void onPlClick() {
        s.add(Double.parseDouble(txtN.getText()));
        n.add("+");
        txtN.setText("");
    }
    @FXML
    private void onAcClick(){
        for(int i = 0; i < s.size(); i++){
            s.remove(i);
            if(n.size() < i)
                n.remove(i);
        }
        txtN.setText("0");
    }
    @FXML
    private void onCClick(){
        if(txtN.getText() != "")
            txtN.setText(Optional.ofNullable(txtN.getText()).filter(str -> str.length() != 0).map(str -> str.substring(0, str.length() - 1)).orElse(txtN.getText()));
        else
            txtN.setText("0");
    }
    @FXML
    private void onDiClick(){
        s.add(Double.parseDouble(txtN.getText()));
        n.add("/");
        txtN.setText("");
    }
    @FXML
    private void onTiClick(){
        s.add(Double.parseDouble(txtN.getText()));
        n.add("*");
        txtN.setText("");
    }
    @FXML
    private void onMiClick(){
        s.add(Double.parseDouble(txtN.getText()));
        n.add("-");
        txtN.setText("");
    }
    @FXML
    private void onMMClick(){
        if(txtN.getText().startsWith("-"))
            txtN.setText("+" + txtN.getText());
        else
            txtN.setText("-" + txtN.getText());
    }
    @FXML
    private void onEqClick(){
        Double r = (double) 0;
        s.add(Double.parseDouble(txtN.getText()));
        for(int i = 0; i < n.size(); i+=2){
            if(n.get(i) == "+")
                r += s.get(i) + s.get(i+1);
            else if(n.get(i) == "-")
                if(s.get(i).toString().startsWith("-")) {
                    s.remove(i);
                    s.add(Double.parseDouble("(" + txtN.getText() + ")"));
                }else
                    r -= s.get(i) - s.get(i+1);
            else if(n.get(i) == "/")
                r += s.get(i) / s.get(i+1);
            else if(n.get(i) == "*")
                r += s.get(i) * s.get(i+1);
        }
        txtN.setText(r.toString().replaceAll("\\.0+$",""));
    }
}