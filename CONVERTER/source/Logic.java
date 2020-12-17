/*
 *BUILT BY LUPUS LA GOOD ;)
 */

package com.lupus.converter;

public class Logic {
  // Length...
  private static final int metres_in_kilometres = 1000;
  private static final int centimetres_in_metres = 100;
  private static final double centimetres_in_inches = 0.394;
  private static final int milimetres_in_centimetres = 10;
  private static final double yards_in_metres = 1.094;
  private static final double miles_in_kilometre = 0.621;
  private static final double feet_in_metres = 3.28084;
  // Mass...
  private static final double grams_in_kilograms = 1000;
  private static final double pounds_in_kilograms = 2.205;
  // speed...
  private static final double mph_in_kph = 0.6213711922;
  private static final double mps_in_kph = 0.278;
  // Volume...
  private static final double ml_in_l = 1000;
  private static final double cm3_in_l = 1000;
  private static final double cm3_in_M3 = 1000000;
  private static final double litres_in_gallons = 3.785;

  private static double getCm3_in_l() {
    return cm3_in_l;
  }

  private static int getMetres_in_kilometres() {
    return metres_in_kilometres;
  }

  private static int getCentimetres_in_metres() {
    return centimetres_in_metres;
  }

  private static double getCentimetres_in_inches() {
    return centimetres_in_inches;
  }

  private static int getMilimetres_in_centimetre() {
    return milimetres_in_centimetres;
  }

  private static double getYards_in_metres() {
    return yards_in_metres;
  }

  private static double getMiles_in_kilometres() {
    return miles_in_kilometre;
  }

  private static double getFeet_in_metres() {
    return feet_in_metres;
  }

  private static double getGrams_in_kilograms() {
    return grams_in_kilograms;
  }

  private static double getPounds_in_kilograms() {
    return pounds_in_kilograms;
  }

  private static double getMph_in_kph() {
    return mph_in_kph;
  }

  private static double getMps_in_kph() {
    return mps_in_kph;
  }

  private static double getMl_in_l() {
    return ml_in_l;
  }

  private static double getCm3_in_m3() {
    return cm3_in_M3;
  }

  private static double getLitres_in_gallons() {
    return litres_in_gallons;
  }

  protected static double mphToKph(double mph) {
    return mph / getMph_in_kph();
  }

  protected static double mphToMps(double mph) {
    return kphToMps(mphToKph(mph));
  }

  protected static double mpsToKph(double mps) {
    return mps / getMps_in_kph();
  }

  protected static double mpsToMph(double mps) {
    return kphToMph(mpsToKph(mps));
  }

  protected static double kphToMph(double kph) {
    return kph * getMph_in_kph();
  }

  protected static double kphToMps(double kph) {
    return kph * getMps_in_kph();
  }

  protected static double gramsToKilos(double grams) {
    return grams / getGrams_in_kilograms();
  }

  protected static double kilosToGrams(double kilograms) {
    return kilograms * getGrams_in_kilograms();
  }

  protected static double kilosToPounds(double kilograms) {
    return kilograms * getPounds_in_kilograms();
  }

  protected static double poundsToKilos(double pounds) {
    return pounds / getPounds_in_kilograms();
  }

  protected static double gramsToPounds(double grams) {
    return kilosToPounds(gramsToKilos(grams));
  }

  protected static double poundsToGrams(double pounds) {
    return poundsToKilos(kilosToGrams(pounds));
  }

  protected static double metresToKilometres(double metres) {
    return metres / getMetres_in_kilometres();
  }

  protected static double kilometresToMetres(double kilometres) {
    return kilometres * getMetres_in_kilometres();
  }

  protected static double metresToCentimetres(double metres) {
    return metres * getCentimetres_in_metres();
  }

  protected static double metresToFeet(double metres) {
    return metres * getFeet_in_metres();
  }

  protected static double feetToMetres(double feet) {
    return feet / getFeet_in_metres();
  }

  protected static double centimetresToMetres(double centimetres) {
    return centimetres / getCentimetres_in_metres();
  }

  protected static double centimetresToInches(double centimetres) {
    return centimetres / getCentimetres_in_inches();
  }

  protected static double metresToInches(double metres) {
    return centimetresToInches(metresToCentimetres(metres));
  }

  protected static double metresToYards(double metres) {
    return metres * getYards_in_metres();
  }

  protected static double yardsToMetres(double yards) {
    return yards / getYards_in_metres();
  }

  protected static double kilometresToMiles(double kilometres) {
    return kilometres * getMiles_in_kilometres();
  }

  protected static double milesToKilometres(double miles) {
    return miles / getMiles_in_kilometres();
  }

  protected static double metresToMiles(double metres) {
    return kilometresToMiles(metresToKilometres(metres));
  }

  protected static double kilometresToCentimetres(double kilometres) {
    return metresToCentimetres(kilometresToMetres(kilometres));
  }

  protected static double kilometresToInches(double kilometres) {
    return centimetresToInches(kilometresToCentimetres(kilometres));
  }

  protected static double kilometresToYards(double kilometres) {
    return metresToYards(kilometresToMetres(kilometres));
  }

  protected static double kilometresToFeet(double kilometres) {
    return metresToFeet(kilometresToMetres(kilometres));
  }

  protected static double centimetresToKilometres(double centimetres) {
    return metresToKilometres(centimetresToMetres(centimetres));
  }

  protected static double centimetresToYards(double centimetres) {
    return metresToYards(centimetresToMetres(centimetres));
  }

  protected static double centimetresToMiles(double centimetres) {
    return kilometresToMiles(centimetresToKilometres(centimetres));
  }

  protected static double centimetresToFeet(double centimetres) {
    return kilometresToFeet(centimetresToKilometres(centimetres));
  }

  protected static double inchesToCentimetres(double inches) {
    return inches * getCentimetres_in_inches();
  }

  protected static double inchesToMetres(double inches) {
    return centimetresToMetres(inchesToCentimetres(inches));
  }

  protected static double inchesToKilometres(double inches) {
    return metresToKilometres(inchesToMetres(inches));
  }

  protected static double inchesToYards(double inches) {
    return metresToYards(inchesToMetres(inches));
  }

  protected static double inchesToMiles(double inches) {
    return kilometresToMiles(inchesToKilometres(inches));
  }

  protected static double inchesToFeet(double inches) {
    return metresToFeet(inchesToMetres(inches));
  }

  protected static double yardsToKilometres(double yards) {
    return metresToKilometres(yardsToMetres(yards));
  }

  protected static double yardsToCentimetres(double yards) {
    return metresToCentimetres(yardsToMetres(yards));
  }

  protected static double yardsToInches(double yards) {
    return centimetresToInches(yardsToCentimetres(yards));
  }

  protected static double yardsToMiles(double yards) {
    return kilometresToMiles(yardsToKilometres(yards));
  }

  protected static double yardsToFeet(double yards) {
    return metresToFeet(yardsToMetres(yards));
  }

  protected static double milesToMetres(double miles) {
    return kilometresToMetres(milesToKilometres(miles));
  }

  protected static double milesToCentimetres(double miles) {
    return metresToCentimetres(milesToMetres(miles));
  }

  protected static double milesToInches(double miles) {
    return centimetresToInches(milesToCentimetres(miles));
  }

  protected static double milesToYards(double miles) {
    return metresToYards(milesToMetres(miles));
  }

  protected static double milesToFeet(double miles) {
    return yardsToFeet(milesToYards(miles));
  }

  protected static double feetToKilometres(double feet) {
    return metresToKilometres(feetToMetres(feet));
  }

  protected static double feetToCentimetres(double feet) {
    return metresToCentimetres(feetToMetres(feet));
  }

  protected static double feetToInches(double feet) {
    return centimetresToInches(feetToCentimetres(feet));
  }

  protected static double feetToYards(double feet) {
    return metresToYards(feetToMetres(feet));
  }

  protected static double feetToMiles(double feet) {
    return kilometresToMiles(feetToKilometres(feet));
  }

  protected static double farenheightToCelsius(double farenheight) {
    return ((farenheight - 32) / 1.8);
  }

  protected static double farenheightToKelvin(double farenheight) {
    return ((((farenheight - 32) * 5) / 9) + 273.15);
  }

  protected static double celsiusToFarenheight(double celsius) {
    return ((celsius * 1.8) + 32);
  }

  protected static double celsiusToKelvin(double celsius) {
    return (celsius + 273.25);
  }

  protected static double kelvinToFarenheight(double kelvin) {
    return ((((kelvin - 273.15) * 9) / 5) + 32);
  }

  protected static double kelvinToCelsius(double kelvin) {
    return (kelvin - 273.15);
  }

  protected static double litresToMililitres(double litres) {
    return litres * getMl_in_l();
  }

  protected static double litresToCC(double litres) {
    return litres * getCm3_in_l();
  }

  protected static double ccToLitres(double cc) {
    return cc / getCm3_in_l();
  }

  protected static double litresToGallons(double litres) {
    return litres / getLitres_in_gallons();
  }

  protected static double mililitresToLitres(double ml) {
    return ml / getMl_in_l();
  }

  protected static double mililitresToCC(double ml) {
    return litresToCC(mililitresToLitres(ml)); // converts ml to litre then converts litre to cc...
  }

  protected static double ccToM3(double cc) {
    return cc / getCm3_in_m3();
  }

  protected static double mililitresToM3(double ml) {
    return ccToM3(mililitresToCC(ml));
  }

  protected static double mililitresToGallons(double ml) {
    return litresToGallons(mililitresToLitres(ml));
  }

  protected static double ccToMl(Double cc) {
    return litresToMililitres(ccToLitres(cc));
  }

  protected static double ccToGallons(double cc) {
    return litresToGallons(ccToLitres(cc));
  }

  protected static double m3ToCc(double m3) {
    return m3 * getCm3_in_m3();
  }

  protected static double m3ToLitres(double m3) {
    return ccToLitres(m3ToCc(m3));
  }

  protected static double m3ToMl(double m3) {
    return litresToMililitres(m3ToLitres(m3));
  }

  protected static double m3ToGallons(double m3) {
    return litresToGallons(m3ToLitres(m3));
  }

  protected static double gallonsToLitres(double gallons) {
    return gallons * getLitres_in_gallons();
  }

  protected static double gallonsToMl(double gallons) {
    return litresToMililitres(gallonsToLitres(gallons));
  }

  protected static double gallonsToCc(double gallons) {
    return litresToCC(gallonsToLitres(gallons));
  }

  protected static double gallonsToM3(double gallons) {
    return ccToM3(gallonsToCc(gallons));
  }
}
