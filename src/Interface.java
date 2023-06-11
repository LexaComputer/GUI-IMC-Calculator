import javax.swing.*;
import java.awt.event.*;
/**
* IMC Calculator with GUI.
* @author LexaComputer
* @version 1.0
* @since 06/11/2023
* */
public class Interface extends JFrame implements ActionListener{
    /**
     * Declaracion de los objetos a usar
     * */
    private JTextField heightField,weightField;
    private JLabel heightLabel,weightLabel,imcResult,imcTable;
    private JButton resultButton;

    /**
     * Constructor que contiene el diseño del programa
     * */
    public Interface(){
        setLayout(null);
        heightField = new JTextField();
        heightField.setBounds(10,75,180,25);
        add(heightField);

        weightField = new JTextField();
        weightField.setBounds(10,30,180,25);
        add(weightField);

        weightLabel = new JLabel("Enter your weight. (Kg)");
        weightLabel.setBounds(10,10,180,20);
        add(weightLabel);

        heightLabel = new JLabel("Enter your height. (m)");
        heightLabel.setBounds(10,55,180,20);
        add(heightLabel);

        /**
         *  JLabel permite usar algunas etiquetas html por lo tanto se aprovechan para hacer
         *  saltos de lineas en el JLabel.
         * */
        imcTable = new JLabel("<html><body>&emsp;~ IMC Table ~ <br><br><18.5 Underweight<br>18.5-24.9 Healthy<br>25.0-29.9 Overweight<br>30.0-34.9 Obesity I" +
                "<br>35.0-39.9 Obesity II<br>>40 Obesisty III</body></html>");
        imcTable.setBounds(230,10,140,125);
        add(imcTable);

        imcResult = new JLabel("Result: ");
        imcResult.setBounds(10,130,100,30);
        add(imcResult);

        resultButton = new JButton("Calculate");
        resultButton.setBounds(10,105,100,20);
        add(resultButton);
        resultButton.addActionListener(this);

        /**
         * Nombre del programa en la ventana
         * */
        setTitle("IMC Calculator");
    }

    /**
     * funcion que detectará el uso del boton
     * @param e se utiliza para obtener el estado del botón
     * */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resultButton){
            Float parseWeight = Float.parseFloat(weightField.getText());
            Float parseHeight = Float.parseFloat(heightField.getText());
            Double tempHeight = Math.pow(parseHeight,2);
            Double formula = parseWeight / tempHeight;
            formula = Math.round(formula * 10.0) / 10.0;
            imcResult.setText("Result: " + formula);
        }
    }

    /**
     * Funcion main contiene los ajustes de la ventana del programa
     * */
    public static void main(String[] args) {
        Interface window = new Interface();
        window.setBounds(0,0,380,200);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}
