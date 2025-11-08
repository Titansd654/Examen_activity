package com.example.examen_activity
import java.io.Serializable

class Operaciones:Serializable {

    var num1:Float= 0.0f
    var num2 :Float = 0.0f;
    constructor() {
        this.num1 = 0.0f;
        this.num2 = 0.0f;

    }
    public fun sumaOperacion():Float {
        var resultadoSuma:Float=0.0f
        resultadoSuma = num1 + num2
        return resultadoSuma
    }
    public fun restaOperacion():Float{
        var resultadoResta:Float=0.0f
        resultadoResta = num1 - num2
        return resultadoResta
    }
    public fun multiplicacionOperacion():Float{
        var resultadoMultiplicacion:Float=0.0f
        resultadoMultiplicacion = num1 * num2
        return resultadoMultiplicacion
    }
    public fun divisionOperacion() :Float {
        var resultadoDivision:Float=0.0f
        resultadoDivision = num1 / num2
        return resultadoDivision
    }
}