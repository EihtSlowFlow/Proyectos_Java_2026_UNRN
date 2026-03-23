1)
Sobre el ejercicio 1 del trabajo practico 1, se pide que cada vez que se inscriba un participante
en un concurso se guarde en un archivo de texto, la fecha/hora de inscripción, el id del participante
y el id del concurso, con el siguiente formato:
dd/mm/yyyy, id_participante, id_concurso
dd/mm/yyyy, id_participante, id_concurso
dd/mm/yyyy, id_participante, id_concurso
dd/mm/yyyy, id_participante, id_concurso
 . . .

 2)
 Sobre el ejercicio 2 del trabajo práctico 1, se solicita que cada vez que se calcule el costo de una
 cena o almuerzo se almacene en un archivo de texto la fecha/hora y el monto total. De la siguiente
 forma:
 dd/mm/yyyy || 1100
 dd/mm/yyyy || 590
 dd/mm/yyyy || 2314.3
 dd/mm/yyyy || 1100
 . . .

 3)
 Ahora, en lugar de generar un archivo tenemos que almacenar los registros del ejercicio 1 y 2 en
 una tabla de una base de datos relacional.
 Desde un Main, se debe poder instanciar los modelos correspondientes (por ejemplo, Concurso o
 Pedido), para que registre la inscripción o la venta en un archivo de texto o en la base de datos.

 4)
  De forma similar a como implementó lo anterior, cada vez que se registre una persona en un
 concurso, enviarle un email. Para ello utilice mail trap (ayuda: https://mailtrap.io/blog/sending-
 email-using-java/#What-is-the-most-popular-option-for-sending-emails-using-Java).

 5)
 Con estos cambios, los test automatizados que teníamos van a pinchar. Hagámoslos funcionar.
 Lo que necesitamos lograr es poder testear la lógica de negocios aislada de las cuestiones técnicas
 (archivos de texto, base de datos, envío de mail). Es decir, el test debe correr sin escribir en disco
 o en la base de datos o enviar el email de forma verdadera. Para eso utilizaremos un Fake Object
 (u objeto de mentira).