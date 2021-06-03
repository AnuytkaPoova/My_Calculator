package com.a_ches.mycalculator;

public class Calculator {

    private double firstArg; //первое введеное значение
    private double secondArg; //второе введеное значение

    private StringBuilder inputStr = new StringBuilder();

    //переменная для хранение
    private double actionSelected;

    private State state; // state - это текущее состояние калькулятора.
    // Показывает на каком этапе работы находится калькулятор.

    private enum State { // список элементов для вывода калькулятором
        firstArgInput,
        secondArgInput,
        resultShow
    }

    public Calculator() {
        state = State.firstArgInput; //конструктор для инициалзации полей
    }

    public void onNumPressed(double buttonId) {//реакция на нажатие кнопки с цифрой
        if (state == State.resultShow) {
            state = State.firstArgInput;
        }
        if (inputStr.length() < 9) {
            switch ((int) buttonId) {
                case R.id.Btn_0:
                    if (inputStr.length() != 0) {
                        inputStr.append("0");
                    }
                    break;
                case R.id.Btn_1:
                    inputStr.append("1");
                    break;
                case R.id.Btn_2:
                    inputStr.append("2");
                    break;
                case R.id.Btn_3:
                    inputStr.append("3");
                    break;
                case R.id.Btn_4:
                    inputStr.append("4");
                    break;
                case R.id.Btn_5:
                    inputStr.append("5");
                    break;
                case R.id.Btn_6:
                    inputStr.append("6");
                    break;
                case R.id.Btn_7:
                    inputStr.append("7");
                    break;
                case R.id.Btn_8:
                    inputStr.append("8");
                    break;
                case R.id.Btn_9:
                    inputStr.append("9");
                    break;
                case R.id.Btn_comma_sign:
                    inputStr.append(".");
                    break;
                case R.id.Btn_del:
                    inputStr.setLength(inputStr.length() -1);
                    break;
                //case R.id.Btn_percent:
                  //  firstArg = Double.parseDouble(inputStr.toString());
                    //inputStr.append(firstArg / 100);;
                    //break;

            }
        }
    }

    public void onActionPressed(double actionId) {//реакция на нажатие кнопки арифметических действий
        if (actionId == R.id.Btn_equally && state == State.secondArgInput) { //при нажатии равно
            secondArg = Double.parseDouble(inputStr.toString());
            state = State.resultShow;
            inputStr.setLength(0);
            switch ((int) actionSelected) {
                case R.id.Btn_division:
                    inputStr.append(firstArg / secondArg);
                    break;
                case R.id.Btn_min:
                    inputStr.append(firstArg - secondArg);
                    break;
                case R.id.Btn_plus:
                    inputStr.append(firstArg + secondArg);
                    break;
                case R.id.Btn_x:
                    inputStr.append(firstArg * secondArg);
                    break;
                case R.id.Btn_C:
                    actionSelected = 0;
                    state = State.firstArgInput;
                    inputStr.setLength(0);
                    break;
            }

        } else if (inputStr.length() > 0 && state == State.firstArgInput) { //при нажатии кнопки действия после ввода первого числа
            firstArg = Double.parseDouble(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch ((int) actionId) {
                case R.id.Btn_C:
                    actionSelected = 0;
                    state = State.firstArgInput;
                    break;
                case R.id.Btn_min_or_plus:
                    actionSelected = R.id.Btn_min_or_plus; // нет реализации
                    break;

                    //case R.id.Btn_percent:
                    //actionSelected = R.id.Btn_percent; // нет реализации
                   // inputStr.append(firstArg / 100);
                    //break;

                case R.id.Btn_division:
                    actionSelected = R.id.Btn_division;
                    break;
                case R.id.Btn_min:
                    actionSelected = R.id.Btn_min;
                    break;
                case R.id.Btn_plus:
                    actionSelected = R.id.Btn_plus;
                    break;
                case R.id.Btn_x:
                    actionSelected = R.id.Btn_x;
                    break;
                case R.id.Btn_equally:
                    actionSelected = R.id.Btn_equally;
                    break;

            }

        } else if (actionId == R.id.Btn_C && state == State.resultShow || actionId == R.id.Btn_C && state == State.secondArgInput) {
            state = State.firstArgInput;
            inputStr.setLength(0);
        } //else if (actionId == R.id.Btn_percent && state == State.firstArgInput ) {
           // inputStr.append(firstArg / 100);}
        // else if ( actionId == R.id.Btn_percent && state == State.secondArgInput) {
         //   inputStr.append(secondArg / 100);;}



    }

    // для отображения  вводимых значений и результата вычислений

    public String getText() { // проучаем строку из стринг билдера и возвращаем ее
        return inputStr.toString();

    }
}
