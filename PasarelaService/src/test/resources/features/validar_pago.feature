Feature: Validar el pago.
	Es posible validar el pago.

	Scenario: Validar pago sin fondos
  	Given numero de tarjeta valido
  	And cvv valido
  	And No hay fondos
  	When intento validar pago
  	Then operacion denegada
        
	Scenario: validar pago con Cvv incorrecto
  	Given numero de tarjeta valido
    And cvv incorrecto
    When intento validar pago
  	Then operacion denegada
  	
  	Scenario: validar pago con tarjeta invalida
			Given numero de tarjeta invalido
			And cvv valido
			When intento validar pago con tarjeta invalida
			Then operacion denegada

	Scenario: validar pago con todo correcto
			Given numero de tarjeta valido
			And cvv valido
			And si hay fondos
			When intento validar pago con todo correcto
			Then operacion aprobada
		
		