package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.calculadora.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private StringBuilder input = new StringBuilder(); // Guarda o que o usuário digita
    private double num1 = 0, num2 = 0; // Números para o cálculo
    private String operador = ""; // Operação atual

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        View.OnClickListener numeroClickListener = v -> {
            Button botao = (Button) v;
            input.append(botao.getText().toString());
            binding.txtVisor.setText(input.toString());
        };

        binding.btn0.setOnClickListener(numeroClickListener);
        binding.btn1.setOnClickListener(numeroClickListener);
        binding.btn2.setOnClickListener(numeroClickListener);
        binding.btn3.setOnClickListener(numeroClickListener);
        binding.btn4.setOnClickListener(numeroClickListener);
        binding.btn5.setOnClickListener(numeroClickListener);
        binding.btn6.setOnClickListener(numeroClickListener);
        binding.btn7.setOnClickListener(numeroClickListener);
        binding.btn8.setOnClickListener(numeroClickListener);
        binding.btn9.setOnClickListener(numeroClickListener);

        View.OnClickListener operadorClickListener = v -> {
            Button botao = (Button) v;
            if (input.length() > 0) {
                num1 = Double.parseDouble(input.toString());
                operador = botao.getText().toString();
                input.setLength(0); // Limpa para digitar o próximo número
            }
        };

        binding.btnSoma.setOnClickListener(operadorClickListener);
        binding.btnSubtracao.setOnClickListener(operadorClickListener);
        binding.btnMultiplicacao.setOnClickListener(operadorClickListener);
        binding.btnDivisao.setOnClickListener(operadorClickListener);
        binding.btnPorcentagem.setOnClickListener(operadorClickListener);

        binding.btnIgual.setOnClickListener(v -> {
            if (input.length() > 0 && !operador.isEmpty()) {
                num2 = Double.parseDouble(input.toString());
                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = num1 + num2;
                        break;
                    case "-":
                        resultado = num1 - num2;
                        break;
                    case "*":
                        resultado = num2 != 0 ? num1 * num2 : 0;
                        break;
                    case "/":
                        resultado = num2 != 0 ? num1 / num2 : 0;
                        break;
                    case "%":
                        resultado = num1 % num2;
                        break;
                }

                binding.txtVisor.setText(String.valueOf(resultado));
                num1 = resultado;
                input.setLength(0);
            }
        });

        binding.btnAC.setOnClickListener(v -> { // reseta tudo
            input.setLength(0);
            num1 = 0;
            num2 = 0;
            operador = "";
            binding.txtVisor.setText("0");
        });
    }
}