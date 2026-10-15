PA EQU 30h
PB EQU 31h
CA EQU 32h
CB EQU 33h

org 1000h

patron db 01010011b
msj db "GANASTE"

org 2000h

mov al,11111111b
out CA,al
mov al, 0
out CB,al
mov bx, offset patron
mov dl, [bx]

loop: in al,PA
cmp al,dl
jz fin

mov ah,al
xor ah,dl
not ah
mov al,ah
out PB,al

jmp loop

fin: mov bx, offset msj
mov al, 7
int 7

int 0

end