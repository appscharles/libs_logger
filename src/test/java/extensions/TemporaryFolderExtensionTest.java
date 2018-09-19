package extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * The type Temporary folder extension.
 */
public class TemporaryFolderExtensionTest implements BeforeEachCallback, AfterEachCallback {

    private final File parentFolder;

    private File folder;

    /**
     * Instantiates a new Temporary folder extension.
     */
    public TemporaryFolderExtensionTest() {
        this(null);
    }

    /**
     * Instantiates a new Temporary folder extension.
     *
     * @param parentFolder the parent folder
     */
    public TemporaryFolderExtensionTest(File parentFolder) {
        this.parentFolder = parentFolder;
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        if (folder != null) {
            recursiveDelete(folder);
        }
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws IOException {
        folder = File.createTempFile("junit", "", parentFolder);
        folder.delete();
        folder.mkdir();
    }

    /**
     * New file file.
     *
     * @param fileName the file name
     * @return the file
     * @throws IOException the io exception
     */
    public File newFile(String fileName) throws IOException {
        File file = new File(getRoot(), fileName);
        if (!file.createNewFile()) {
            throw new IOException("a file with the name \'" + fileName + "\' already exists in the test folder");
        }
        return file;
    }

    /**
     * New folder file.
     *
     * @param folderName the folder name
     * @return the file
     */
    public File newFolder(String folderName) {
        File file = getRoot();
        file = new File(file, folderName);
        file.mkdir();
        return file;
    }

    public File newFolder() {
        File file = getRoot();
        file = new File(file, UUID.randomUUID().toString());
        file.mkdir();
        return file;
    }

    private void recursiveDelete(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File each : files) {
                recursiveDelete(each);
            }
        }
        file.delete();
    }

    /**
     * Gets root.
     *
     * @return the root
     */
    public File getRoot() {
        if (folder == null) {
            throw new IllegalStateException("the temporary folder has not yet been created");
        }
        return folder;
    }

}
