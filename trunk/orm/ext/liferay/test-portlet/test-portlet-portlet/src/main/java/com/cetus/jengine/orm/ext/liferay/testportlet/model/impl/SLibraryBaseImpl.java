package com.cetus.jengine.orm.ext.liferay.testportlet.model.impl;

import com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary;
import com.cetus.jengine.orm.ext.liferay.testportlet.service.SLibraryLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the SLibrary service. Represents a row in the &quot;SB_SLibrary&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SLibraryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SLibraryImpl
 * @see com.cetus.jengine.orm.ext.liferay.testportlet.model.SLibrary
 * @generated
 */
public abstract class SLibraryBaseImpl extends SLibraryModelImpl
    implements SLibrary {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a s library model instance should use the {@link SLibrary} interface instead.
     */
    public void persist() throws SystemException {
        if (this.isNew()) {
            SLibraryLocalServiceUtil.addSLibrary(this);
        } else {
            SLibraryLocalServiceUtil.updateSLibrary(this);
        }
    }
}
