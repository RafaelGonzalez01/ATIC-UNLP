PA EQU 30h
PB EQU 31h
CA EQU 32h
CB EQU 33h

org 1000h

res db 10000001b
msj db "ACTIVADO"

org 2000h

mov al, 11111111b
out CA, al
mov bx, offset res
mov ah,[bx]

loop: in al, PA
cmp ah,al
jnz loop
mov bx, offset msj
mov al, 8
int 7
jmp loop


end 