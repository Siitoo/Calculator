package l.sito.calculator;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private String num = ""; //Aixó és el número actual.
    private String last_num = "";
    private String equal_last_num = "";
    private char operation = ' ';
    private char last_operation = ' ';
    private TextView numview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        numview = findViewById(R.id.curr_num);
        numview.setText(num);
    }

    public void onClickDigit(View view)
    {
        Button b = (Button)view;
        num += b.getText().toString().charAt(0);
        numview.setText(num);

    }

    public void OnClickOperator(View view)
    {
        Button b = (Button)view;
        operation = b.getText().toString().charAt(0);
        last_num = num;
        num = "";
        numview.setText(num);

    }

    public void OnClickDot(View view)
    {
        Button b = (Button)view;
        num += b.getText().toString().charAt(0);
        numview.setText(num);
    }

    public void OnClickEqual(View view)
    {
        double num1 = Double.valueOf(last_num);
        double num2 = Double.valueOf(num);
        String res = "0";

        switch (operation)
        {
            case '+':

                num1 += num2;
                res =  Double.toString(num1);
                last_operation = operation;
                break;

            case '-':

                num1 -= num2;
                res =  Double.toString(num1);
                last_operation = operation;
                break;

            case '*':

                num1 *= num2;
                res =  Double.toString(num1);
                last_operation = operation;
                break;

            case '/':

                num1 /= num2;
                res =  Double.toString(num1);
                last_operation = operation;
                break;

            case '=':

                operation = last_operation;
                OnClickEqual(view);
                break;
        }

        last_num =res;
        numview.setText(last_num);
    }
}
