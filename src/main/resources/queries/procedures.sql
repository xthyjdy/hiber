DELIMITER //
CREATE PROCEDURE get_items()
BEGIN
	SELECT * FROM it;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_item(in ITEM_ID bigint)
BEGIN
	SELECT * FROM it WHERE id = ITEM_ID;
END //
DELIMITER ;

DELIMITER //
create procedure FIND_ITEM_TOTAL(in PARAM_ITEM_ID bigint, out PARAM_TOTAL bigint)
begin
	select count(*) into PARAM_TOTAL from it;
	select * from it where ID = PARAM_ITEM_ID;
end//
DELIMITER ;

DELIMITER //
create procedure update_item(in NEW_NAME varchar(25), in ITEM_ID bigint)
begin
	UPDATE it SET name = NEW_NAME WHERE id = ITEM_ID LIMIT 1;
end//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE get_message_by_id(in MS_ID bigint)
BEGIN
	SELECT id, text ms WHERE id = MS_ID;
END //
DELIMITER ;


DELIMITER //
CREATE PROCEDURE get_ms_by_id(in M_ID bigint)
BEGIN
	SELECT * FROM ms WHERE id = M_ID;
END //
DELIMITER ;