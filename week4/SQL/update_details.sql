DELIMITER $$
CREATE PROCEDURE update_details(sales DECIMAL, quota DECIMAL)
BEGIN
	DECLARE bonus INT DEFAULT 0;
	DECLARE updated VARCHAR(5) DEFAULT 'No';
	IF sales > (quota+200) THEN
		SET bonus = (sales-quota)/4;
		SET updated = 'Yes';
	END IF;
	SELECT CONCAT('Updated =', updated, ', ', 'Bonus =', bonus);
END; $$
DELIMITER ;

CALL update_details (10100, 10000);

CALL update_details (10500, 10000);