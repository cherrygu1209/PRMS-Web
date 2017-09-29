package sg.edu.nus.iss.phoenix.radiopresenter.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException;
import sg.edu.nus.iss.phoenix.radiopresenter.entity.RadioPresenter;

public interface PresenterDAO {

	/**
	 * createValueObject-method. This method is used when the Dao class needs to
	 * create new value object instance. The reason why this method exists is
	 * that sometimes the programmer may want to extend also the valueObject and
	 * then this method can be over-rided to return extended valueObject.
     * @return 
	 */
	public abstract RadioPresenter createValueObject();

	/**
	 * getObject-method. This will create and load valueObject contents from
	 * database using given Primary-Key as identifier. This method is just a
	 * convenience method for the real load-method which accepts the valueObject
	 * as a parameter. Returned valueObject will be created using the
	 * createValueObject() method.
     * @param name
     * @return 
     * @throws sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException 
     * @throws java.sql.SQLException 
	 */
	public abstract RadioPresenter getObject(String name)
			throws NotFoundException, SQLException;

	/**
	 * load-method. This will load valueObject contents from database using
	 * Primary-Key as identifier. Upper layer should use this so that
	 * valueObject instance is created and only primary-key should be specified.
	 * Then call this method to complete other persistent information. This
	 * method will overwrite all other fields except primary-key and possible
	 * runtime variables. If load can not find matching row, NotFoundException
	 * will be thrown.
	 * 
	 * @param valueObject
	 *            This parameter contains the class instance to be loaded.
	 *            Primary-key field must be set for this to work properly.
     * @throws sg.edu.nus.iss.phoenix.core.exceptions.NotFoundException
     * @throws java.sql.SQLException
	 */
	public abstract void load(RadioPresenter valueObject)
			throws NotFoundException, SQLException;

	/**
	 * LoadAll-method. This will read all contents from database table and build
	 * a List containing valueObjects. Please note, that this method will
	 * consume huge amounts of resources if table has lot's of rows. This should
	 * only be used when target tables have only small amounts of data.
	 * 
     * @return 
     * @throws java.sql.SQLException
	 */
	public abstract List<RadioPresenter> loadAll() throws SQLException;

	/**
	 * create-method. This will create new row in database according to supplied
	 * valueObject contents. Make sure that values for all NOT NULL columns are
	 * correctly specified. Also, if this table does not use automatic
	 * surrogate-keys the primary-key must be specified. After INSERT command
	 * this method will read the generated primary-key back to valueObject if
	 * automatic surrogate-keys were used.
	 * 
	 * @param valueObject
	 *            This parameter contains the class instance to be created. If
	 *            automatic surrogate-keys are not used the Primary-key field
	 *            must be set for this to work properly.
     * @throws java.sql.SQLException
	 */
	
	public abstract List<RadioPresenter> searchMatching(RadioPresenter valueObject)
			throws SQLException;

}