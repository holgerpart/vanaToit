INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')
INSERT INTO public.contact (id, first_name, last_name) VALUES (DEFAULT, 'Sander', 'Arusoo')

INSERT INTO public.unit (id, name) VALUES (DEFAULT, 'kg')
INSERT INTO public.unit (id, name) VALUES (DEFAULT, 'pcs')

INSERT INTO public.status (id, description) VALUES (DEFAULT, 'Completed')
INSERT INTO public.status (id, description) VALUES (DEFAULT, 'Cancelled')
INSERT INTO public.status (id, description) VALUES (DEFAULT, 'Open')

INSERT INTO public.role (id, role) VALUES (DEFAULT, 'user')
INSERT INTO public.role (id, role) VALUES (DEFAULT, 'shop')

INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn')
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu')

INSERT INTO public."user" (id, name, password, contact_id) VALUES (DEFAULT, 'sanderarusoo', 'parool', 1)
INSERT INTO public."user" (id, name, password, contact_id) VALUES (DEFAULT, 'sannu', 'salasõna', 2)
INSERT INTO public."user" (id, name, password, contact_id) VALUES (DEFAULT, 'miku', 'qwerty', 3)

INSERT INTO public.type (id, name) VALUES (DEFAULT, 'kuivaine')
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'puuvili')
INSERT INTO public.type (id, name) VALUES (DEFAULT, 'juurvili')

INSERT INTO public.profile (id, aadress, tel_number, longitude, latitude, city_id) VALUES (DEFAULT, 'Tammsaare 1', '1881', 52.00000, 53.00000, 1)
INSERT INTO public.profile (id, aadress, tel_number, longitude, latitude, city_id) VALUES (DEFAULT, 'Uus 12', '53334', 51.00000, 51.00000, 2)

INSERT INTO public.food (id, name, type_id) VALUES (DEFAULT, 'tatar', 1)
INSERT INTO public.food (id, name, type_id) VALUES (DEFAULT, 'õun', 2)

INSERT INTO public.shop (id, name, profile_id) VALUES (DEFAULT, 'Tondi Selver', 1)
INSERT INTO public.shop (id, name, profile_id) VALUES (DEFAULT, 'Mustika Prisma', 2)

INSERT INTO public.shop_food (id, shop_id, food_id, quantity, unit_id, is_available, date_time, expiration_date, comments) VALUES (DEFAULT, 1, 2, 3, 2, true, '2022-04-27 14:58:28.000000', '2022-04-28', null)
INSERT INTO public.shop_food (id, shop_id, food_id, quantity, unit_id, is_available, date_time, expiration_date, comments) VALUES (DEFAULT, 2, 1, 3, 2, true, '2022-04-27 14:59:28.000000', '2022-04-28', null)

INSERT INTO public.shop_food_log (id, shop_id, food_id, quantity, unit_id, date_time) VALUES (DEFAULT, 1, 1, 4, 2, '2022-04-27 15:07:06.000000')
INSERT INTO public.shop_food_log (id, shop_id, food_id, quantity, unit_id, date_time) VALUES (DEFAULT, 2, 2, 7, 2, '2022-04-27 15:08:06.000000')

INSERT INTO public.authorized_user (id, user_id, shop_id) VALUES (DEFAULT, 1, 1)
INSERT INTO public.authorized_user (id, user_id, shop_id) VALUES (DEFAULT, 2, 2)

INSERT INTO public.book_food (id, user_id, shop_food_id, quantity, status_id) VALUES (DEFAULT, 1, 1, 2, 3)
INSERT INTO public.book_food (id, user_id, shop_food_id, quantity, status_id) VALUES (DEFAULT, 2, 2, 5, 3)

INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 1)
INSERT INTO public.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 2)