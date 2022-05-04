INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo');

INSERT INTO public.unit (id, name) VALUES (DEFAULT, 'kg');
INSERT INTO public.unit (id, name) VALUES (DEFAULT, 'pcs');

INSERT INTO public.status (id, description) VALUES (DEFAULT, 'Completed');
INSERT INTO public.status (id, description) VALUES (DEFAULT, 'Cancelled');
INSERT INTO public.status (id, description) VALUES (DEFAULT, 'Open');

INSERT INTO public.role (id, role) VALUES (DEFAULT, 'user');
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'shop');

INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Narva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kohtla-Järve');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Maardu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Rakvere');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kuressaare');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Sillamäe');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Valga');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Võru');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Jõhvi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Keila');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Haapsalu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Paide');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Saue');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Elva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tapa');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Põlva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Türi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Rapla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Jõgeva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kiviõli ');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Põltsamaa');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Sindi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Paldiski');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kärdla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kunda');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tõrva');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Narva-Jõesuu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kehra');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Loksa');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Otepää');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Räpina');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tamsalu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kilingi-Nõmm');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Karksi-Nuia');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Võhma');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Antsla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Lihula');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Mustvee');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Suure-Jaani');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Abja-Paluoja');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Püssi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Mõisaküla');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Kallaste');


INSERT INTO public."user" (id, name, password, contact_id) VALUES (DEFAULT, 'sanderarusoo', 'parool', 1);
INSERT INTO public."user" (id, name, password, contact_id) VALUES (DEFAULT, 'sannu', 'salasõna', 2);
INSERT INTO public."user" (id, name, password, contact_id) VALUES (DEFAULT, 'miku', 'qwerty', 3);

INSERT INTO public.type (id, name) VALUES (DEFAULT, 'kuivaine');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'puuvili');
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'juurvili');

INSERT INTO public.profile (id, aadress, tel_number, longitude, latitude, city_id) VALUES (DEFAULT, 'Tammsaare 1', '1881', 52.00000, 53.00000, 1);
INSERT INTO public.profile (id, aadress, tel_number, longitude, latitude, city_id) VALUES (DEFAULT, 'Uus 12', '53334', 51.00000, 51.00000, 2);

INSERT INTO public.food (id, name, type_id) VALUES (DEFAULT, 'tatar', 1);
INSERT INTO public.food (id, name, type_id) VALUES (DEFAULT, 'õun', 2);

INSERT INTO public.shop (id, name, profile_id) VALUES (DEFAULT, 'Tondi Selver', 1);
INSERT INTO public.shop (id, name, profile_id) VALUES (DEFAULT, 'Mustika Prisma', 2);

INSERT INTO public.shop_food (id, shop_id, food_id, quantity, unit_id, is_available, date_time, expiration_date, comments) VALUES (DEFAULT, 1, 2, 3, 2, true, '2022-04-27 14:58:28.000000', '2022-04-28', null);
INSERT INTO public.shop_food (id, shop_id, food_id, quantity, unit_id, is_available, date_time, expiration_date, comments) VALUES (DEFAULT, 2, 1, 3, 2, true, '2022-04-27 14:59:28.000000', '2022-04-28', null);

INSERT INTO public.shop_food_log (id, shop_id, food_id, quantity, unit_id, date_time) VALUES (DEFAULT, 1, 1, 4, 2, '2022-04-27 15:07:06.000000');
INSERT INTO public.shop_food_log (id, shop_id, food_id, quantity, unit_id, date_time) VALUES (DEFAULT, 2, 2, 7, 2, '2022-04-27 15:08:06.000000');

INSERT INTO public.authorized_user (id, user_id, shop_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.authorized_user (id, user_id, shop_id) VALUES (DEFAULT, 2, 2);

INSERT INTO public.book_food (id, user_id, shop_food_id, quantity, status_id) VALUES (DEFAULT, 1, 1, 2, 3);
INSERT INTO public.book_food (id, user_id, shop_food_id, quantity, status_id) VALUES (DEFAULT, 2, 2, 5, 3);

INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 2);

