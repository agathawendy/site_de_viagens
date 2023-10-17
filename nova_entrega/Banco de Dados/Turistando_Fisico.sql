CREATE DATABASE turistando;
USE turistando;


CREATE TABLE Usuario (
    IDusuario INTEGER PRIMARY KEY auto_increment,
    nomeUsuario VARCHAR(40),
	emailUsuario VARCHAR(80),
    senhaUsuario VARCHAR(10)
   
);

CREATE TABLE Passagem (
    IDpassagem INTEGER PRIMARY KEY auto_increment,
    precoPassagem DECIMAL(10,2),
    destinoPassagem VARCHAR(40)
);

CREATE TABLE compra (
    IDcompra INTEGER PRIMARY KEY AUTO_INCREMENT,
    fk_Usuario_IDusuario INTEGER,
    fk_Passagem_IDpassagem INTEGER,
    dataCompra VARCHAR(10),
    FOREIGN KEY (fk_Usuario_IDusuario) REFERENCES Usuario (IDusuario),
    FOREIGN KEY (fk_Passagem_IDpassagem) REFERENCES Passagem (IDpassagem)
);


-- salvando(create) os dados
insert into Usuario (nomeUsuario, emailUsuario, senhaUsuario) values
('Maria', 'maria@email.com', '123'),
('João', 'joao@email.com', '345'),
('Andressa', 'andressa@email.com', '678');	
 
insert into Passagem values
(default, '1300.8', 'Rio de Janeiro'),
(default, '1400', 'São Paulo'),
(default, '1240', 'Belo Horizonte'); 


-- Inserir uma compra associada ao usuário com ID 1 e à passagem com ID 1
insert into compra (fk_Usuario_IDusuario, fk_Passagem_IDpassagem, dataCompra) values
(1, 1, '29/09/2023');

insert into compra (fk_Usuario_IDusuario, fk_Passagem_IDpassagem, dataCompra) values
(2, 2, '30/09/2023');


-- consulta(read) dos dados
select * from Usuario;
select * from Passagem;
select * from compra;
select c.IDcompra, c.dataCompra, l.*, u.*
from compra c, Passagem l, Usuario u
where c.IDpassagem = l.IDpassagem and c.IDusuario = u.IDusuario;

-- atualizando(update) os dados
UPDATE Usuario SET nomeUsuario = 'Maria', emailUsuario = 'maria@email.com', senhaUsuario = '123' WHERE IDusuario = 1;
UPDATE Passagem SET destinoPassagem = 'Rio de Janeiro', precoPassagem = '1300.8' WHERE IDpassagem = 1;     
UPDATE compras SET dataCompra = '29/09/2023', IDusuario = 1, IDpassagem = 1 WHERE IDcompra = 1;

-- deletando dados
DELETE FROM Usuario WHERE IDusuario IN (4, 5, 6, 7, 8, 9, 10, 11, 12);
DELETE FROM Passagem WHERE IDpassagem IN (4, 5, 6, 7, 8, 9, 10, 11, 12);  
DELETE FROM compra WHERE IDcompra IN (4, 5, 6, 7, 8, 9, 10, 11, 12);

	