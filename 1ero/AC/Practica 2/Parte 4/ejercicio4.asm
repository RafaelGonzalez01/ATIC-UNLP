PA EQU 30h
PB EQU 31h
CA EQU 32h
CB EQU 33h

org 1000h

txt db "Arquitectura de Computadoras: ACTIVADA"
fin db ?

org 2000h

mov al, 11111111b
out CA, al
mov al, 0
out CB, al
mov dl,0

loop: in al,PA
call a
cmp dl,1
jz finp
call b
call c
jmp loop

finp: int 0

org 3000h

a: in al,PA
cmp al,0
jnz fina
mov dl,1
fina: ret

b: not al
out PB,al
not al
ret

c: and al, 00000001b
jz finc
push bx
mov bx,offset txt
mov al, offset fin - offset txt
int 7
pop bx
finc: ret

end 
