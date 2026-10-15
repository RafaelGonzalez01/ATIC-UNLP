
        org 1000h
texto   db "UNLP"  
fintxt  db ?
txtenv  db 0
txtend  db 255
PA      equ 30h
PB      equ 31h
CA      equ 32h
CB      equ 33h

        org 2000h
        mov bx, offset texto
        mov cl, offset fintxt - offset texto

        mov al, 00000000b
        out CB, al
        mov al, 00000000b
        out CA, al

        
loop:   cmp cl, 0
        jz fin
        
        pool:   mov al, 0
                out PB, al
                mov al, [BX]
                out PB, al
                inc bx
                dec cl
                jnz pool

        mov al, txtend
        out PB, al
        
fin:    hlt

        org 3200h
        

        end