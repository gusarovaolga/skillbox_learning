import javax.swing.*;

public class MainForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextField surname;
    private JTextField name;
    private JTextField patronymic;
    private JLabel textLabel;
    private JPanel textPanel;
    private JPanel insertPanel;
    private JPanel buttonPanel;
    private JLabel surnameLabel;
    private JLabel nameLabel;
    private JLabel patronymicLabel;

    public MainForm() {

        collapseButton.addActionListener(actionEvent -> {
            if (collapseButton.getText().equals("Collapse")) {

                if (name.getText().isEmpty() || surname.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "Заполните имя и фамилию.");
                } else {
                    name.setVisible(false);
                    nameLabel.setVisible(false);
                    surname.setVisible(false);
                    surnameLabel.setVisible(false);
                    patronymic.setText(collapseText());
                    patronymicLabel.setText("Фамилия " +
                            "Имя " +
                            " Отчество");
                    collapseButton.setText("Expand");
                    textLabel.setText("");
                    surnameLabel.setText("");
                    nameLabel.setText("");
                }

            } else if (collapseButton.getText().equals("Expand")) {
                String[] fio = patronymic.getText().split("\\s");

                if (fio.length > 3) {
                    textLabel.setText("");
                    surnameLabel.setText("");
                    nameLabel.setText("");
                    JOptionPane.showMessageDialog(mainPanel, "Не более трёх слов (Фамилия и (или) Имя и (или) Отчество).");
                } else {

                    if (fio.length < 2) {
                        textLabel.setText("");
                        surnameLabel.setText("");
                        nameLabel.setText("");
                        JOptionPane.showMessageDialog(mainPanel, "Не менее двух слов (Фамилия и Имя)");
                    } else {
                        int n = fio.length - 1;
                        surname.setText(fio[0]);
                        name.setText(fio[1]);
                        patronymic.setText("");
                        if (fio.length == 3) {
                            patronymic.setText(fio[n]);
                        }
                        name.setVisible(true);
                        nameLabel.setVisible(true);
                        surname.setVisible(true);
                        surnameLabel.setVisible(true);
                        patronymicLabel.setText("Отчество");
                        surnameLabel.setText("Фамилия");
                        nameLabel.setText("Имя");
                        collapseButton.setText("Collapse");
                    }
                }
            }
        });
    }

    private String collapseText() {
        return surname.getText() + " " + name.getText() + " " + patronymic.getText();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
