# Concordion Options
_Since_: Concordion 2.0.0

The [@ConcordionOptions](http://concordion.github.io/concordion/latest/javadoc/org/concordion/api/option/ConcordionOptions.html) annotation can be applied to specifications to configure aspects of Concordion.

## Saving Source HTML
For debug purposes, you may wish to save a copy of the source HTML. For example, when using Markdown format, you may want to see the HTML that is generated by the Markdown parser, and used as the input specification to Concordion.

To save a copy, use the `@ConcordionOptions` annotation on the fixture class with the value of `copySourceHtmlToDir` set to the target directory. For example:

    @RunWith(ConcordionRunner.class)
    @ConcordionOptions(copySourceHtmlToDir="/tmp")
    public class ...

The target directory can include system property values in the path, by wrapping the system property key in `${` and `}`. For example:

    @ConcordionOptions(copySourceHtmlToDir="${java.io.tmpdir}/output")

will write to the output directory under the system temp folder.

## Markdown Syntax Extensions
Markdown extensions allow you to change and/or extend the behaviour of the [Markdown](../specificationType/markdown/Markdown.html) parser, for example to change the behaviour of new lines, or to support definition lists.

To add markdown extensions, use the `@ConcordionOptions` annotation on the fixture class with the value of `markdownExtensions` set to an array of `MarkdownExtension` enumerations. For example:

    @RunWith(ConcordionRunner.class)
    @ConcordionOptions(markdownExtensions={MarkdownExtensions.WIKILINKS, MarkdownExtensions.AUTOLINKS})
    public class ...
      
See the [MarkdownExtension](http://concordion.github.io/concordion/latest/javadoc/org/concordion/api/option/MarkdownExtensions.html) javadoc for a definition of the available extensions. (Note, the underlying Markdown parser is [Pegdown](https://github.com/sirthias/pegdown), which defines the [available extensions](https://github.com/sirthias/pegdown/blob/master/README.markdown#introduction).)

### [No extra extensions](- "no-extra-extensions")

Without additional extensions, the following are translated as-is.

<div class="example">
  <h3>Example</h3>
  <table concordion:execute="#html=translate(#md)">
    <tr>
      <th concordion:set="#md">Markdown</th>
      <th concordion:assertEquals="#html">Resulting HTML</th>
    </tr>
    <tr>
      <td>[[not a wikilink]]</td>
      <td>[[not a wikilink]]</td>
    </tr>
    <tr>
      <td>http://concordion.org</td>
      <td>http://concordion.org</td>
    </tr>
  </table>
</div>
 
### [With WIKILINKS and QUOTES extensions](- "extra-extensions")

Given the method `withPegdownExtensions(int options)` has been [called](- "withWikilinkAndAutolink()") with `options` set to `org.pegdown.Extensions.WIKILINKS | org.pegdown.Extensions.AUTOLINKS`, the following are now translated as shown:

<div class="example">
  <h3>Example</h3>
  <table concordion:execute="#html=translate(#md)">
    <tr>
      <th concordion:set="#md">Markdown</th>
      <th concordion:assertEquals="#html">Resulting HTML</th>
    </tr>
    <tr>
      <td>[[wikilink]]</td>
      <td>&lt;a href="./wikilink.html">wikilink&lt;/a></td>
    </tr>
    <tr>
      <td>http://concordion.org</td>
      <td>&lt;a href="http://concordion.org"&gt;http://concordion.org&lt;/a&gt;</td>
    </tr>
  </table>
</div>

## Additional namespace declarations
In order to include Concordion commands with namespaces other than the default Concordion namespaces, such as those available in extensions, you must declare the namespace.

This is only applicable to Markdown specifications. In HTML specifications, the namespaces are declared directly in the HTML.

Add the `@ConcordionOptions` annotation to the fixture class, with the `declareNamespaces` element set to a list of strings, where the values alternate between namespace prefixes and the namespace they are mapped to. For example:

    @RunWith(ConcordionRunner.class)
    @ConcordionOptions(declareNamespaces={"ext", "urn:concordion-extensions:2010"})
    public class MyFixture

### [Valid declarations](- "valid-namespace-declarations")

|[_parse_](- "#mappings=parse(#value)")[declareNamespaces value](- "#value")|[Namespace mappings](- "?=#mappings")|
| ------------------------------------------ | --------------- |
| {"ext", "urn:concordion-extensions:2010"} | {"ext"= "urn:concordion-extensions:2010"} |
| {"foo", "http://bar", "x", "urn:baz"} | { "x"= "urn:baz", "foo"= "http://bar"} |

### [Invalid declarations](- "invalid-namespace-declarations")

If passing an odd number of arguments, an error will occur:

|[_parse_](- "#message=parseAndReturnExceptionMessage(#value)")[declareNamespaces value](- "#value")|[Exception message](- "?=#message")|
| ------------------------------------------ | --------------- |
| {"foo", "http://bar", "x"} | The declareNamespaces element of @ConcordionOptions must include an even number of arguments, alternating between a namespace prefix and the namespace it maps to |