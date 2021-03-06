package net.yslibrary.licenseadapter;

import java.util.List;
import net.yslibrary.licenseadapter.internal.LoadLicenseTask;

/**
 * Created by yshrsmz on 2016/04/15.
 */
public class Licenses {

  // License names
  public static final String NAME_APACHE_V2 = "Apache License V2.0";
  public static final String NAME_MIT = "MIT LICENSE";
  public static final String NAME_BSD = "BSD LICENSE";

  // License file names
  public static final String FILE_AUTO = "license_file_auto";
  public static final String FILE_NO_EXTENSION = "LICENSE";
  public static final String FILE_TXT = "LICENSE.txt";
  public static final String FILE_MD = "LICENSE.md";

  private static final String DEF_BRANCH = "master";
  private static final String DEF_LICENSE_NAME = NAME_APACHE_V2;

  /**
   * predefined LicenseEntry for Apache License v2.0
   */
  public static final License LICENSE_APACHE_V2 = License.builder()
      .setName(DEF_LICENSE_NAME)
      .setUrl("http://www.apache.org/licenses/LICENSE-2.0")
      .build();

  /**
   * create LicenseEntry from GitHub repository url.
   * Regard license as Apache v2.
   * LicenseAdapter will check if the repo has any of {@link Licenses#FILE_TXT},
   * {@link Licenses#FILE_MD} or {@link Licenses#FILE_NO_EXTENSION}
   *
   * @param gitRepo target library's GitHub repository. should be "user/repoName"
   * @return GitHubLicenseEntry
   * @deprecated use {@link Licenses#fromGitHubApacheV2(String)} instead.
   */
  @Deprecated
  public static GitHubLicenseEntry fromGitHub(String gitRepo) {
    return new GitHubLicenseEntry(DEF_LICENSE_NAME, gitRepo, DEF_BRANCH, null, FILE_AUTO);
  }

  /**
   * create LicenseEntry from GitHub repository url and License text path.
   * Regard license as Apache v2
   *
   * @param gitRepo             target library's GitHub repository. should be "user/repoName"
   * @param relativeLicensePath relative path to the license file. you can use predefined {@link
   *                            Licenses#FILE_TXT}, {@link Licenses#FILE_MD}, {@link
   *                            Licenses#FILE_NO_EXTENSION} or {@link Licenses#FILE_AUTO}
   * @return GitHubLicenseEntry
   * @deprecated use {@link Licenses#fromGitHubApacheV2(String, String)} instead.
   */
  @Deprecated
  public static GitHubLicenseEntry fromGitHub(String gitRepo, String relativeLicensePath) {
    return new GitHubLicenseEntry(DEF_LICENSE_NAME, gitRepo, DEF_BRANCH, null, relativeLicensePath);
  }

  /**
   * create LicenseEntry from GitHub repository url and user define {@link License} instance.
   * This method can be used when the repository does not provide license text file.
   * You can use predefined {@link Licenses#LICENSE_APACHE_V2} or your own implementation.
   *
   * @param gitRepo target library's GitHub repository. should be "user/repoName"
   * @param license user defined {@link License} instance
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHub(String gitRepo, License license) {
    return new GitHubLicenseEntry(null, gitRepo, DEF_BRANCH, license, null);
  }

  /**
   * Create LicenseEntry from GitHub repository url and license name
   *
   * @param gitRepo             target library's GitHub repository. should be "user/repoName"
   * @param licenseName         license name to use. you can use predefined {@link
   *                            Licenses#NAME_APACHE_V2}, {@link Licenses#NAME_MIT} and {@link
   *                            Licenses#NAME_BSD}
   * @param relativeLicensePath relative path to the license file. you can use predefined {@link
   *                            Licenses#FILE_TXT}, {@link Licenses#FILE_MD}, {@link
   *                            Licenses#FILE_NO_EXTENSION} or {@link Licenses#FILE_AUTO}
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHub(String gitRepo, String licenseName,
      String relativeLicensePath) {
    return new GitHubLicenseEntry(licenseName, gitRepo, DEF_BRANCH, null, relativeLicensePath);
  }

  /**
   * Create Apache v2 LicenseEntry from GitHub repository url.
   * LicenseAdapter will check if the repo has any of {@link Licenses#FILE_TXT},
   * {@link Licenses#FILE_MD} or {@link Licenses#FILE_NO_EXTENSION}
   *
   * @param gitRepo target library's GitHub repository. should be "user/repoName"
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHubApacheV2(String gitRepo) {
    return new GitHubLicenseEntry(NAME_APACHE_V2, gitRepo, DEF_BRANCH, null, FILE_AUTO);
  }

  /**
   * Create Apache v2 LicenseEntry from GitHub repository url.
   *
   * @param gitRepo             target library's GitHub repository. should be "user/repoName"
   * @param relativeLicensePath relative path to the license file. you can use predefined {@link
   *                            Licenses#FILE_TXT}, {@link Licenses#FILE_MD}, {@link
   *                            Licenses#FILE_NO_EXTENSION} or {@link Licenses#FILE_AUTO}
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHubApacheV2(String gitRepo, String relativeLicensePath) {
    return new GitHubLicenseEntry(NAME_APACHE_V2, gitRepo, DEF_BRANCH, null, relativeLicensePath);
  }

  /**
   * Create MIT LicenseEntry from GitHub repository url.
   * LicenseAdapter will check if the repo has any of {@link Licenses#FILE_TXT},
   * {@link Licenses#FILE_MD} or {@link Licenses#FILE_NO_EXTENSION}
   *
   * @param gitRepo target library's GitHub repository. should be "user/repoName"
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHubMIT(String gitRepo) {
    return new GitHubLicenseEntry(NAME_MIT, gitRepo, DEF_BRANCH, null, FILE_AUTO);
  }

  /**
   * Create MIT LicenseEntry from GitHub repository url.
   *
   * @param gitRepo             target library's GitHub repository. should be "user/repoName"
   * @param relativeLicensePath relative path to the license file. you can use predefined {@link
   *                            Licenses#FILE_TXT}, {@link Licenses#FILE_MD}, {@link
   *                            Licenses#FILE_NO_EXTENSION} or {@link Licenses#FILE_AUTO}
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHubMIT(String gitRepo, String relativeLicensePath) {
    return new GitHubLicenseEntry(NAME_MIT, gitRepo, DEF_BRANCH, null, relativeLicensePath);
  }

  /**
   * Create BSD LicenseEntry from GitHub repository url.
   * LicenseAdapter will check if the repo has any of {@link Licenses#FILE_TXT},
   * {@link Licenses#FILE_MD} or {@link Licenses#FILE_NO_EXTENSION}
   *
   * @param gitRepo target library's GitHub repository. should be "user/repoName"
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHubBSD(String gitRepo) {
    return new GitHubLicenseEntry(NAME_BSD, gitRepo, DEF_BRANCH, null, FILE_AUTO);
  }

  /**
   * Create BSD LicenseEntry from GitHub repository url.
   *
   * @param gitRepo             target library's GitHub repository. should be "user/repoName"
   * @param relativeLicensePath relative path to the license file. you can use predefined {@link
   *                            Licenses#FILE_TXT}, {@link Licenses#FILE_MD} and {@link
   *                            Licenses#FILE_NO_EXTENSION}
   * @return GitHubLicenseEntry
   */
  public static GitHubLicenseEntry fromGitHubBSD(String gitRepo, String relativeLicensePath) {
    return new GitHubLicenseEntry(NAME_BSD, gitRepo, DEF_BRANCH, null, relativeLicensePath);
  }

  /**
   * Create LicenseEntry from provided name, author and url.
   * This method can be used when the library is not hosted on GitHub, and does not provide license
   * info.
   *
   * @param name   Library's name
   * @param author author's name
   * @param url    url for the library hosting page
   * @return NoContentLicenseEntry
   */
  public static NoContentLicenseEntry noContent(String name, String author, String url) {
    return new NoContentLicenseEntry(name, author, url);
  }

  /**
   * Create LicenseEntry from provided name, author and text.
   * This method can be used when the library does not provide the license online.
   *
   * @param name   Library's name
   * @param author author's name
   * @param text   the license
   * @return NoContentLicenseEntry
   */
  public static NoLinkLicenseEntry noLink(String name, String author, String text) {
    return new NoLinkLicenseEntry(name, author, text);
  }

  /**
   * Load provided licenses
   *
   * @param entries list of LicenseEntries to load
   */
  public static void load(List<LicenseEntry> entries) {
    new LoadLicenseTask().execute(entries.toArray(new LicenseEntry[entries.size()]));
  }
}
