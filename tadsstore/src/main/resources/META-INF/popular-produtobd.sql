/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  fernando.tsuda
 * Created: 23/04/2018
 */

INSERT INTO PRODUTOBD.TB_CATEGORIA (NM_CATEGORIA) VALUES
('Bolo'),
('Torta'),
('Chocolate'),
('Morango'),
('Abacaxi'),
('Coco'),
('Cenoura'),
('Frutas'),
('Crocante'),
('Light');

INSERT INTO PRODUTOBD.TB_PRODUTO (NM_PRODUTO, DS_PRODUTO, DT_CADASTRO, VL_COMPRA, VL_VENDA, QT_PRODUTO) VALUES
('Bolo de chocolate', 'Melhor bolo de chocolate do mundo', NOW(), 100.00, 110.00, 100),
('Torta crocante', 'Torta para todas as horas', NOW(), 120.00, 150.00, 100),
('Bolo de cenoura', 'Este é O BOLO!!!', NOW(), 90.00, 105.00, 100),
('Bolo light', 'Bolo de frutas porque gordice para quem não quer ganhar peso', NOW(), 150.00, 170.00, 100),
('Floresta negra', 'Muito chocolate', NOW(), 110.00, 200.00, 100),
('Torta de morango', 'Muito morango e muita torta', NOW(), 95.00, 115.00, 100),
('Sonho de valsa', 'Bolo sonho de valsa', NOW(), 95.00, 200.00, 100),
('Morango com leite condensado', 'Bolo muito recheado', NOW(), 150.00, 300.00, 100),
('Abacaxi com coco', 'Bolo para quem gosta de frutas', NOW(), 125.00, 210.00, 100),
('Mega Choco', 'Bolo para quem curte MUITO CHOCOLATE', NOW(), 160.00, 190.00, 100);

INSERT INTO PRODUTOBD.TB_IMAGEM (NM_IMAGEM, DS_IMAGEM, ID_PRODUTO) VALUES 
('bolo01.jpg', 'Imagem do bolo 1', 1),
('bolo02.jpg', 'Imagem do bolo 2', 1),
('bolo03.jpg', 'Imagem do bolo 3', 1),
('bolo04.jpg', 'Imagem do bolo 4', 1),
('bolo01.jpg', 'Imagem do bolo', 2),
('bolo02.jpg', 'Imagem do bolo', 3),
('bolo03.jpg', 'Imagem do bolo', 4),
('bolo04.jpg', 'Imagem do bolo', 5),
('bolo01.jpg', 'Imagem do bolo', 6),
('bolo02.jpg', 'Imagem do bolo', 7),
('bolo03.jpg', 'Imagem do bolo', 8),
('bolo04.jpg', 'Imagem do bolo', 9),
('bolo05.jpg', 'Imagem do bolo', 10);

INSERT INTO PRODUTOBD.TB_PRODUTO_CATEGORIA (ID_PRODUTO, ID_CATEGORIA) VALUES 
(1, 1),
(1, 3),
(2, 2),
(2, 10),
(3, 1),
(3, 7),
(3, 10),
(4, 1),
(4, 8),
(4, 10),
(5, 1),
(5, 3),
(6, 2),
(6, 4),
(7, 1),
(7, 3),
(7, 9),
(8, 1),
(8, 4),
(9, 1),
(9, 5),
(9, 6),
(9, 10),
(10, 1),
(10, 3);