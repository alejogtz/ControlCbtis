-------------------<Funcion que indica si Ya esta registrado por hoy>--------------------
CREATE OR REPLACE FUNCTION isAlreadyRegistered(NoControl int) RETURNS INT 
BEGIN
	DECLARE SIHAY INT DEFAULT 0;
	SELECT COUNT(1) AS CANTIDAD INTO SIHAY FROM estudiante NATURAL JOIN asistencia WHERE estudiante.NoControl = NoControl	AND asistencia.Fecha = CURRENT_DATE;
	
	IF SIHAY!=0 THEN
		RETURN 1;
	ELSE 
		RETURN 0;
	END IF;
END


-------------------<Funcion que indica si tiene al menos una asistencia>--------------------


CREATE OR REPLACE FUNCTION cuantasAsistenciasTiene(NoControl int) RETURNS INT 
BEGIN
	DECLARE counter INT DEFAULT 0;
	SELECT COUNT(1) AS CANTIDAD INTO counter FROM estudiante NATURAL JOIN asistencia WHERE estudiante.NoControl = NoControl;
	
	RETURN counter;
END
