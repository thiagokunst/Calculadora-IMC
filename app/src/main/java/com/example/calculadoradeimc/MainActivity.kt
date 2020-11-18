package com.example.calculadoradeimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.calculadoradeimc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botao.setOnClickListener({calculateIMC()})
    }

    private fun calculateIMC(){
        val stringInTextField = binding.alturaEditText.text.toString()
        val stringInTextField2 = binding.pesoEditText.text.toString()
        val altura = stringInTextField.toFloatOrNull()
        val peso = stringInTextField2.toFloatOrNull()

        if (altura == null || peso == null) {
            binding.altura.hint = "Insira a altura aqui"
            binding.peso.hint = "Insira o peso aqui"
            binding.imcTexto.text="IMC"
            return
        }

        val imc: Float = peso / (altura*altura)
        val imcf = "%.2f".format(imc)

        binding.imcNumero.text = imcf

        when {
            imc < 18.5 -> binding.imcTexto.text="Abaixo do peso"
            imc <= 25 -> binding.imcTexto.text="Peso Normal"
            imc <= 30 -> binding.imcTexto.text="Sobrepeso"
            imc <= 35 -> binding.imcTexto.text="Obesidade Grau I"
            imc <= 39.9 -> binding.imcTexto.text="Obesidade Grau II"
            else -> binding.imcTexto.text="Obesidade Grau III"
        }
    }



}