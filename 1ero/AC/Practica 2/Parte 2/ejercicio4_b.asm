PA EQU 30h
PB EQU 31h
CA EQU 32h 
CB EQU 33h

ORG 1000h 

msj db "ORGANIZACION Y ARQUITECTURA DE COMPUTADORAS"
FIN db ?

ORG 2000H   

mov cl, offset fin - offset msj
mov bx, offset msj
call ini_pio

imprimir: mov al, [bx]
call imprimir_caracter
inc bx
dec cl
jnz imprimir

int 0 

ORG 3000h

ini_pio: push ax
mov al, 00000001b
out CA,al
mov al, 00000000b
out CB,al
pop ax
ret

poll: push ax
in al, PA
and al, 00000001b
jnz poll
pop ax
ret

flanco_ascendente: push ax
in al, PA
and al, 11111101b
out PA, al
in al, PA
or al,00000010b
out PA,al
pop ax
ret

imprimir_caracter: call poll
out PB, al
call flanco_ascendente
ret

end  