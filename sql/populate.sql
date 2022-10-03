INSERT INTO public.products (id, amount, code, description, type, value) VALUES (5, 20, '804904c7-1612-4d4a-a59e-fcf76c968ea7', 'Aspirador de pó', 'ELETRODOMESTICO', 299.50);
INSERT INTO public.products (id, amount, code, description, type, value) VALUES (6, 10, 'f3d95d77-aae6-42bc-b34e-08a59d5dd751', 'Geladeira Consul', 'ELETRODOMESTICO', 2999.10);
INSERT INTO public.products (id, amount, code, description, type, value) VALUES (1, 8, 'c904e1d6-7af5-470f-8090-028ab2bc75ed', 'TV Sony 50 Polegadas', 'ELETRONICO', 1780.80);
INSERT INTO public.products (id, amount, code, description, type, value) VALUES (3, 7, 'd6435e0d-f46d-42da-bddc-174748ffa1a4', 'Sofa 3 Lugares', 'MOVEL', 1489.99);
INSERT INTO public.products (id, amount, code, description, type, value) VALUES (2, 48, 'd1b820b6-30e1-4b3c-b092-2967cdc70e99', 'XBOX One', 'ELETRONICO', 2500.25);
INSERT INTO public.products (id, amount, code, description, type, value) VALUES (4, 2, '317966df-229c-43cd-afe9-2f6ff6fd46ac', 'Cama Queen Size', 'MOVEL', 1999.99);

INSERT INTO public.stock_movements (id, amount, date, movement, sale_value, product_id) VALUES (1, 10, '2022-09-14 00:00:00.000000', 'SAIDA', 4200.00, 5);
INSERT INTO public.stock_movements (id, amount, date, movement, sale_value, product_id) VALUES (2, 2, '2022-09-14 00:00:00.000000', 'SAIDA', 7000.00, 2);
