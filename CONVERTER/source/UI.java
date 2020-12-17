/*
 * BUILT BY LUPUS LA GOOD ;)
 */

package com.lupus.converter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;


interface Defaults {
  default void add(JFrame frame, Component component) {
    frame.getContentPane().add(component);
  }

  default void setToolTip() {
    UIManager.put("ToolTip.background", Color.black);
    UIManager.put("ToolTip.foreground", Color.cyan);
  }
}

public class UI implements Defaults, ItemListener, ActionListener {

  /** THIS CLASS LAUNCHES THE GRAPHICAL USER INTERFACE FOR THE CONVERTER */
  private JFrame frame;

  private JComboBox<String> measurement; // Whether Weight Length Volume etc...
  private JLabel convertLabel = new JLabel("Convert:"); // Simply Displays The Word "Convert"
  private JTextField value; // User Enters The Value to be converted Here
  private JComboBox<String> currentUnit =
      new JComboBox<String>(); // The Current Unit Of Measurement Of Value entered
  private JLabel toLabel = new JLabel("To:"); // Simply Displays The Word "To"
  private JComboBox<String> desiredUnit; // The Desired Measurement Unit Of The User
  private static JTextField result; // Displays The Result
  private JButton convert; // Calls The Conversion Methods...
  private JLabel from = new JLabel("From:");


  // The Getters And Setters...
  private JLabel getFrom() {
    return from;
  }
  private void setFrom(JLabel from) {
    this.from = from;
  }

  private void setFrame(JFrame frame) {
    this.frame = frame;
  }

  private JFrame getFrame() {
    return frame;
  }

  private void setMeasurement(JComboBox<String> measurement) {
    this.measurement = measurement;
  }

  private JComboBox<String> getMeasurement() {
    return measurement;
  }

  private JLabel getConvertLabel() {
    return convertLabel;
  }

  private void setValue(JTextField value) {
    this.value = value;
  }

  private JTextField getValue() {
    return value;
  }

  private void setCurrentUnit(JComboBox<String> currentUnit) {
    this.currentUnit = currentUnit;
  }

  private JComboBox<String> getCurrentUnit() {
    return currentUnit;
  }

  private JLabel getToLabel() {
    return toLabel;
  }

  private void setDesiredUnit(JComboBox<String> desiredUnit) {
    this.desiredUnit = desiredUnit;
  }

  private JComboBox<String> getDesiredUnit() {
    return desiredUnit;
  }

  private void setResult(JTextField result) {
    UI.result = result;
  }

  protected static JTextField getResult() {
    return result;
  }

  private void setConvert(JButton convert) {
    this.convert = convert;
  }

  private JButton getConvert() {
    return convert;
  }

  private void setUnitValues() {
    String msr = (String) getMeasurement().getSelectedItem();
    String[] massValues = {"<Empty>", "Kilograms", "Grams", "Pounds"};
    String[] lengthValues = {
      "<Empty>", "Metres", "Kilometres", "Centimetres", "Inches", "Yards", "Miles", "Feet"
    };
    String[] temperatureValues = {"<Empty>", "Farenheight", "Celsius", "Kelvin"};
    String[] volumeValues = {
      "<Empty>", "Litres", "Mililitres", "Cubic Centimetres", "Cubic Metres", "Gallons"
    };
    String[] speedValues = {
      "<Empty>", "Kilometres per Hour", "Miles per Hour", "Metres per Second"
    };
    String[] empty = {"<Empty>", "<Empty>"};

    if (msr.equalsIgnoreCase("<empty>")) {
      setCurrentUnit(new JComboBox<String>(empty));
      setDesiredUnit(new JComboBox<String>(empty));
    } else if (msr.equalsIgnoreCase("mass")) {
      setCurrentUnit(new JComboBox<String>(massValues));
      setDesiredUnit(new JComboBox<String>(massValues));
    } else if (msr.equalsIgnoreCase("length")) {
      setCurrentUnit(new JComboBox<String>(lengthValues));
      setDesiredUnit(new JComboBox<String>(lengthValues));
    } else if (msr.equalsIgnoreCase("temperature")) {
      setCurrentUnit(new JComboBox<String>(temperatureValues));
      setDesiredUnit(new JComboBox<String>(temperatureValues));
    } else if (msr.equalsIgnoreCase("volume")) {
      setCurrentUnit(new JComboBox<String>(volumeValues));
      setDesiredUnit(new JComboBox<String>(volumeValues));
    } else if (msr.equalsIgnoreCase("speed")) {
      setCurrentUnit(new JComboBox<String>(speedValues));
      setDesiredUnit(new JComboBox<String>(speedValues));
    }
    getCurrentUnit().setBounds(100, 90, 150, 22);
    getDesiredUnit().setBounds(100, 120, 150, 22);
    add(getFrame(), getCurrentUnit());
    add(getFrame(), getDesiredUnit());
  }

  private boolean isEmpty() {
    boolean empty = false;
    String msr = (String) getMeasurement().getSelectedItem();
    String current = (String) getCurrentUnit().getSelectedItem();
    String desired = (String) getDesiredUnit().getSelectedItem();

    if (getValue().getText() == null || getValue().getText().equalsIgnoreCase("")) {
      empty = true;
      getResult().setText("Value Cannot Be Empty!");
      getValue().requestFocus();
    } else if (current.equalsIgnoreCase("") || current.equalsIgnoreCase("<empty>")) {
      empty = true;
      getResult().setText("Units Cannot Be Empty!");
      getCurrentUnit().requestFocus();
    } else if (desired.equalsIgnoreCase("") || desired.equalsIgnoreCase("<empty>")) {
      empty = true;
      getResult().setText("Units Cannot Be Empty!");
      getDesiredUnit().requestFocus();
    }

    if (empty) {
      getResult().setForeground(Color.red);
    }
    getFrame().getContentPane().revalidate();

    return empty;
  }

  private void convertMass() {
    String current = (String) getCurrentUnit().getSelectedItem();
    String desired = (String) getDesiredUnit().getSelectedItem();
    getResult().setForeground(Color.black);
    switch (current) {
      case "Kilograms":
        {
          if (desired.equalsIgnoreCase("kilograms")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("grams")) {
            getResult()
                .setText(Double.toString(Logic.kilosToGrams(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("pounds")) {
            getResult()
                .setText(
                    Double.toString(Logic.kilosToPounds(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Grams":
        {
          if (desired.equalsIgnoreCase("Kilograms")) {
            getResult()
                .setText(Double.toString(Logic.gramsToKilos(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("grams")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("pounds")) {
            getResult()
                .setText(
                    Double.toString(Logic.gramsToPounds(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Pounds":
        {
          if (desired.equalsIgnoreCase("kilograms")) {
            getResult()
                .setText(
                    Double.toString(Logic.poundsToKilos(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("grams")) {
            getResult()
                .setText(
                    Double.toString(Logic.poundsToGrams(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("pounds")) {
            getResult().setText(getValue().getText());
          }
          break;
        }
    }
  }

  private void convertLength() {
    String current = (String) getCurrentUnit().getSelectedItem();
    String desired = (String) getDesiredUnit().getSelectedItem();
    getResult().setForeground(Color.black);

    switch (current) {
      case "Metres":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("Kilometres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.metresToKilometres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.metresToCentimetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult()
                .setText(
                    Double.toString(Logic.metresToInches(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult()
                .setText(
                    Double.toString(Logic.metresToYards(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult()
                .setText(
                    Double.toString(Logic.metresToMiles(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult()
                .setText(Double.toString(Logic.metresToFeet(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Kilometres":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.kilometresToMetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kilometres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.kilometresToCentimetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.kilometresToInches(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult()
                .setText(
                    Double.toString(Logic.kilometresToYards(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult()
                .setText(
                    Double.toString(Logic.kilometresToMiles(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult()
                .setText(
                    Double.toString(Logic.kilometresToFeet(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Centimetres":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.centimetresToMetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kilometres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.centimetresToKilometres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.centimetresToInches(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.centimetresToYards(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.centimetresToMiles(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult()
                .setText(
                    Double.toString(Logic.centimetresToFeet(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Inches":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult()
                .setText(
                    Double.toString(Logic.inchesToMetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kilometres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.inchesToKilometres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.inchesToCentimetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult()
                .setText(
                    Double.toString(Logic.inchesToYards(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult()
                .setText(
                    Double.toString(Logic.inchesToMiles(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult()
                .setText(Double.toString(Logic.inchesToFeet(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Yards":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult()
                .setText(
                    Double.toString(Logic.yardsToMetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kilometres")) {
            getResult()
                .setText(
                    Double.toString(Logic.yardsToKilometres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.yardsToCentimetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult()
                .setText(
                    Double.toString(Logic.yardsToInches(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult()
                .setText(Double.toString(Logic.yardsToMiles(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult()
                .setText(Double.toString(Logic.yardsToFeet(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Miles":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult()
                .setText(
                    Double.toString(Logic.milesToMetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kilometres")) {
            getResult()
                .setText(
                    Double.toString(Logic.milesToKilometres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.milesToCentimetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult()
                .setText(
                    Double.toString(Logic.milesToInches(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult()
                .setText(Double.toString(Logic.milesToYards(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult()
                .setText(Double.toString(Logic.milesToFeet(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Feet":
        {
          if (desired.equalsIgnoreCase("metres")) {
            getResult()
                .setText(Double.toString(Logic.feetToMetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kilometres")) {
            getResult()
                .setText(
                    Double.toString(Logic.feetToKilometres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("centimetres")) {
            getResult()
                .setText(
                    Double.toString(Logic.feetToCentimetres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("inches")) {
            getResult()
                .setText(Double.toString(Logic.feetToInches(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("yards")) {
            getResult()
                .setText(Double.toString(Logic.feetToYards(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles")) {
            getResult()
                .setText(Double.toString(Logic.feetToMiles(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("feet")) {
            getResult().setText(getValue().getText());
          }
          break;
        }
    }
  }

  private void convertTemperature() {
    String current = (String) getCurrentUnit().getSelectedItem();
    String desired = (String) getDesiredUnit().getSelectedItem();
    getResult().setForeground(Color.black);
    switch (current) {
      case "Farenheight":
        {
          if (desired.equalsIgnoreCase("Celsius")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.farenheightToCelsius(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("farenheight")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("kelvin")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.farenheightToKelvin(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Celsius":
        {
          if (desired.equalsIgnoreCase("farenheight")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.celsiusToFarenheight(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("celsius")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("kelvin")) {
            getResult()
                .setText(
                    Double.toString(Logic.celsiusToKelvin(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Kelvin":
        {
          if (desired.equalsIgnoreCase("farenheight")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.kelvinToFarenheight(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("celsius")) {
            getResult()
                .setText(
                    Double.toString(Logic.kelvinToCelsius(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("kelvin")) {
            getResult().setText(getValue().getText());
          }
          break;
        }
    }
  }

  private void convertVolume() {
    getResult().setForeground(Color.black);
    String current = (String) getCurrentUnit().getSelectedItem();
    String desired = (String) getDesiredUnit().getSelectedItem();

    switch (current) {
      case "Litres":
        {
          if (desired.equalsIgnoreCase("litres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("Mililitres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.litresToMililitres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic centimetres")) {
            getResult()
                .setText(Double.toString((Logic.litresToCC(Double.valueOf(getValue().getText())))));
          } else if (desired.equalsIgnoreCase("cubic metres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("Gallons")) {
            getResult()
                .setText(
                    Double.toString(Logic.litresToGallons(Double.valueOf(getValue().getText()))));
            // Incase you're wondering ...
            // the method .setText() only takes string as parameter...
            // i therefore have to convert the Logic.blahblah() methods which return a double to a
            // String
            // I use the wrapper class Double and call the static method toString() to do this
            // Conversion.
            // The same happens when i call the Logic.blahblah() methods which only accept double as
            // parametres
            // I use the Double.valueOf() method to convert from string..
            // P.S getValue() method returns a JTextField.
            //     getResult() method returns a JLabel....
          }
          break;
        }
      case "Mililitres":
        {
          if (desired.equalsIgnoreCase("litres")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.mililitresToLitres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("mililitres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("cubic centimetres")) {
            getResult()
                .setText(
                    Double.toString(Logic.mililitresToCC(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic metres")) {
            getResult()
                .setText(
                    Double.toString(Logic.mililitresToM3(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("gallons")) {
            getResult()
                .setText(
                    Double.toString(
                        Logic.mililitresToGallons(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Cubic Centimetres":
        {
          if (desired.equalsIgnoreCase("litres")) {
            getResult()
                .setText(Double.toString(Logic.ccToLitres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("mililitres")) {
            getResult().setText(Double.toString(Logic.ccToMl(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic centimetres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("cubic metres")) {
            getResult()
                .setText(Double.toString(Logic.ccToM3(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("gallons")) {
            getResult()
                .setText(Double.toString(Logic.ccToGallons(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Cubic Metres":
        {
          if (desired.equalsIgnoreCase("litres")) {
            getResult().setText(Double.toString(Logic.m3ToLitres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("mililitres")) {
            getResult().setText(Double.toString(Logic.m3ToMl(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic centimetres")) {
            getResult()
                .setText(Double.toString(Logic.m3ToCc(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic metres")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("gallons")) {
            getResult()
                .setText(Double.toString(Logic.m3ToGallons(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Gallons":
        {
          if (desired.equalsIgnoreCase("litres")) {
            getResult()
                .setText(
                    Double.toString(Logic.gallonsToLitres(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("mililitres")) {
            getResult()
                .setText(Double.toString(Logic.gallonsToMl(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic centimetres")) {
            getResult()
                .setText(Double.toString(Logic.gallonsToCc(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("cubic metres")) {
            getResult()
                .setText(Double.toString(Logic.gallonsToM3(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("gallons")) {
            getResult().setText(getValue().getText());
          }
          break;
        }
    }
  }

  private void convertSpeed() {
    String current = (String) getCurrentUnit().getSelectedItem();
    String desired = (String) getDesiredUnit().getSelectedItem();
    getResult().setForeground(Color.black);
    switch (current) {
      case "Kilometres per Hour":
        {
          if (desired.equalsIgnoreCase("kilometres per hour")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("miles per hour")) {
            getResult()
                .setText(Double.toString(Logic.kphToMph(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("metres per second")) {
            getResult()
                .setText(Double.toString(Logic.kphToMps(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Miles per Hour":
        {
          if (desired.equalsIgnoreCase("kilometres per hour")) {
            getResult()
                .setText(Double.toString(Logic.mphToKph(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles per hour")) {
            getResult().setText(getValue().getText());
          } else if (desired.equalsIgnoreCase("metres per second")) {
            getResult()
                .setText(Double.toString(Logic.mphToMps(Double.valueOf(getValue().getText()))));
          }
          break;
        }
      case "Metres per Second":
        {
          if (desired.equalsIgnoreCase("kilometres per hour")) {
            getResult()
                .setText(Double.toString(Logic.mpsToKph(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("miles per hour")) {
            getResult()
                .setText(Double.toString(Logic.mpsToMph(Double.valueOf(getValue().getText()))));
          } else if (desired.equalsIgnoreCase("metres per second")) {
            getResult().setText(getValue().getText());
          }
          break;
        }
    }
  }

  public UI() {
    setFrame(new JFrame("CONVERTER"));
    getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getFrame().setBounds(500, 200, 500, 300);
    getFrame().getContentPane().setLayout(null);
    getFrame().getContentPane().setBackground(new Color(0x123456));
    getFrame().setResizable(true);

    ImageIcon image = new ImageIcon("samurai.jpg");
    getFrame().setIconImage(image.getImage());

    String[] measures = {"<Empty>", "Mass", "Length", "Temperature", "Volume", "Speed"};
    setMeasurement(new JComboBox<String>(measures));
    getMeasurement().setBounds(30, 10, 150, 22);
    getMeasurement().addItemListener(this);
    add(getFrame(), getMeasurement());

    getConvertLabel().setBounds(30, 60, 100, 22);
    getConvertLabel().setForeground(Color.cyan);
    add(getFrame(), getConvertLabel());

    setValue(new JTextField());
    getValue().setBounds(100, 60, 150, 22);
    getValue().setToolTipText("Enter Value To Convert");
    getValue().setFont(new Font("Arial", Font.BOLD, 12));
    setToolTip();
    getValue().requestFocus();
    add(getFrame(), getValue());

    setUnitValues();

    getFrom().setBounds(30, 90, 90, 22);
    getFrom().setForeground(Color.cyan);
    add(getFrame(), getFrom());

    getToLabel().setBounds(30, 120, 90, 22);
    getToLabel().setForeground(Color.cyan);
    add(getFrame(), getToLabel());

    setResult(new JTextField());
    getResult().setBounds(30, 180, 190, 22);
    getResult().setFont(new Font("Arial", Font.BOLD, 12));
    getResult().setEditable(false);
    add(getFrame(), getResult());

    setConvert(new JButton("Convert"));
    getConvert().setBounds(70, 210, 90, 21);
    getConvert().addActionListener(this);
    getConvert().setActionCommand("convert");
    add(getFrame(), getConvert());

    getFrame().setVisible(true);
  }

  public void itemStateChanged(ItemEvent e) {
    if (e.getSource() == getMeasurement()) {
      getFrame().remove(getCurrentUnit());
      getFrame().remove(getDesiredUnit());
      setUnitValues();
      getFrame().getContentPane().revalidate();
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equalsIgnoreCase("convert")) {
      getResult().setText("");
      getFrame().getContentPane().revalidate();
      String msrment = (String) getMeasurement().getSelectedItem();
      switch (msrment) {
        case "<Empty>":
          {
            getResult().setText("Select A Unit");
            getResult().setForeground(Color.red);
            getMeasurement().requestFocus();
            getFrame().getContentPane().revalidate();
            break;
          }
        case "Mass":
          {
            if (!isEmpty()) convertMass();

            break;
          }
        case "Length":
          {
            if (!isEmpty()) convertLength();
            break;
          }
        case "Temperature":
          {
            if (!isEmpty()) convertTemperature();
            break;
          }
        case "Volume":
          {
            if (!isEmpty()) convertVolume();
            break;
          }
        case "Speed":
          {
            if (!isEmpty()) convertSpeed();
            break;
          }
      }
    }
  }

  public static void main(String[] args) {
    new UI();
  }
}
