PA EQU 30h
PB EQU 31h
CA EQU 32h
CB EQU 33h

org 1000h

num db 00000001b

org 2000h

mov al, 0
out CB, al
out CA, al
mov cl,1
mov bx, offset num

loop: mov ch, 7
izq: mov al, [bx]
out PB, al
call ROTAR_IZQ
dec ch
jnz izq
mov ch, 7
der: mov al, [bx]
out PB, al
call ROTAR_DER_N
dec ch
jnz der
jmp loop

int 0

org 3000h

ROTAR_IZQ: push ax
mov al,[bx]
add al, al
jnc fin
add al,1
fin: mov [bx],al
pop ax
ret

ROTARIZQ_N:call ROTAR_IZQ
dec cl
jnz ROTARIZQ_N
ret

ROTAR_DER_N: push ax
mov al, 8
sub al,cl
mov cl,al
pop ax
call ROTARIZQ_N
ret

end 